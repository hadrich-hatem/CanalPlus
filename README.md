Projet d'automatisation des tests - Exemple : Modifier adresse d'un abonne
===========================================================================

Cloner le projet
----------------

Pour cloner le projet vous avez besoin d'un outil de version Git et tapez cette commande :

`git clone https://github.com/hadrich-hatem/CanalPlus.git`


Pré-requis
----------

1) Télécharger et installer l'IDE Eclipse la version 2019 
	- LIEN : https://www.eclipse.org/downloads/download.php?file=/oomph/epp/2019-12/R/eclipse-inst-win64.exe
2) Installer le plugin de spring tool suite (STS) dans le market place d'eclipse
3) Installer le plugin cucumber eclipse : 
	- Menu Help > Install new software...
	- Dans le "work with" tapez cette URL "https://cucumber.github.io/cucumber-eclipse-update-site" puis tapez Entrer
	- Sélectionner l'element Cucumber Eclipse Plugin
	- Décocher l'option "Contact all update sites during install to find required software"
	- Cliquer sur next > Finish > install anyway ... jusqu'au la fin de l'installation

Compiler
--------

Pour compiler, vous avez besoin de Maven.

`mvn clean`


Verifier
--------

Pour verifier que le test est fonctionne avec Junit et Maven, vous tapez cette commande.

`mvn test`

`mvn install`