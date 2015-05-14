chmod 400 id_rsa
scp -i id_rsa artifacts/libs/backend-*.jar tw@52.68.95.171:applications/fam/application-latest.jar
ssh -i id_rsa tw@52.68.95.171 "nohup applications/fam/deploy.sh > /dev/null 2>&1"