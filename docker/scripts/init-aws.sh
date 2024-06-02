#!/bin/bash

# import scripts
# note that here we specify location of files inside localstack container. In docker-compose.yml file we specify these locations.
SCRIPTS_PATH="/tmp/localstack/*"
DDB_SCRIPT_PATH="/tmp/localstack/init-ddb.sh"

# make files executable
chmod +x $SCRIPTS_PATH
# run the scripts
eval "$DDB_SCRIPT_PATH"