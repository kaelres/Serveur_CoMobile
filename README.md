# Serveur Connectivitée Mobile

## Utilisation du logiciel

 Afin de lancer le serveur il est nécessaire de lancer l'application en premier lieu. Par la suite il vous sera possible de voir trois boutons :
  * Le premier vous permet de démarrer le serveur.
  * Le second vous permet d'arrêter le serveur.
  * Le dernier vous permet d'arrêter le serveur ainsi que de quitter l'application.
  
  Il est important de noter que l'état du serveur (allumé/éteint) vous sera indiqué par un message présent au-dessus des boutons "Démarrer" et "Arrêter".
  
  Une fois le serveur lancé il vous est possible de vous connecter à celui-ci depuis un naviguateur. Pour celà entrez dans la barre d'adresse :
```
  localhost:8080
```
Ceci est valable si vous êtes sur la machine serveur, si vous êtes sur une machine différente de celle du serveur il vous faudra rentrez l'adresse ip de la machine serveur suivi de `:8080`. 
Exemple :  90.73.166.242:8080

Une fois ceci-fait vous pouvez voir une carte google map qui dispose dans le coin supérieur gauche d'un menu. Cliquez sur celui-ci vous permet d'accèder à une liste d'opérateurs et de technologies, cochez celles que vous voulez voir apparaître sur la carte et validez votre choxi en appuyant sur le bouton. Après un temps de chargement vous devriez pouvoir voir apparaître la couverture mobile.
> Prenez en compte que valider un choix sans avoir coché aucune option ne fera rien apparaître, il faut au minimum cocher un opérateur ou une technologie.
  
  ## Fichier jar
   Un fichier ".jar est déjà présent dans le fichier `\target` prêt à être utilisé.
   
