
set /P inputFile=Nom du fichier d'entree: 

java -jar base64-1.0.0.jar -e -i %inputFile% -o base64.txt
pause