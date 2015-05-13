#!/bin/sh

chmod 400 id_rsa
scp -i id_rsa backend-*.jar tw@54.223.180.108:fam/application-latest.jar