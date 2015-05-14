chmod 400 id_rsa

scp -i id_rsa artifacts/libs/backend-*.jar $USER@$HOST:applications/fam/application-latest.jar
ssh -i id_rsa $USER@$HOST "nohup applications/fam/deploy.sh > /dev/null 2>&1"