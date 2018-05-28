app.service('Map', ['$http', function($http, $q) {

    this.init = function() {
        var options = {
            center: new google.maps.LatLng(43.300000, 5.400000),
            zoom: 12
        };
        this.map = new google.maps.Map(
            document.getElementById("map"), options
        );
        this.places = new google.maps.places.PlacesService(this.map);

        var input = /** @type {!HTMLInputElement} */(
            document.getElementById('pac-input'));
        var autocomplete = new google.maps.places.Autocomplete(input);
        /*this.map.data.loadGeoJson('test.json');
        this.map.data.setStyle({visible:false});*/
    }

    this.search = function(str) {
        var d = $q.defer();
        this.places.textSearch({query: str}, function(results, status) {
            if (status == 'OK') {
                d.resolve(results[0]);
            }
            else d.reject(status);
        });
        return d.promise;
    }

    this.addMarker = function(res) {
        if(this.marker) this.marker.setMap(null);
        this.marker = new google.maps.Marker({
            map: this.map,
            position: res.geometry.location,
            animation: google.maps.Animation.DROP
        });
        this.map.setCenter(res.geometry.location);
    }

    /*this.callDataBase = function(tabState){
        var res = {};
        if(tabState[0]){
            res = "app/test2.json";
        }else if(tabState[1]){
            res = "app/testfinal.json";
        }
        return res;
    }*/

    this.layer = function(tabState, cb){
        var req = {
            tabState : tabState
        };

        console.log(req);
        $http.post('/geo',req)
            .then(function(resp){
                var geoJsonObject = resp.data.monGeoJson;
                console.log(geoJsonObject);
                cb(geoJsonObject);
            });
        //this.map.data.addGeoJson(geoJsonObject);

        //var response = monGeoJson(tabState);
        //this.map.data.loadGeoJson(response);

    }


}]);