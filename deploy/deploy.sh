chmod 400 id_rsa
scp -i id_rsa backend-*.jar tw@52.68.95.171:applications/fam/application-latest.jar