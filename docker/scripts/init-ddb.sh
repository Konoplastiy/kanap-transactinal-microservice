echo Creating DynamoDb Tables ...

ledger_accounts_table_definition="
      dynamodb create-table
      --table-name=ledger_accounts
      --endpoint-url http://localhost:4566
      --attribute-definitions AttributeName=pk,AttributeType=S AttributeName=sk,AttributeType=S
      --key-schema AttributeName=pk,KeyType=HASH AttributeName=sk,KeyType=RANGE
      --billing-mode PAY_PER_REQUEST
      --region us-west-2"
awslocal $ledger_accounts_table_definition

payment_transactions_table_definition="
      dynamodb create-table
      --table-name=payment_transactions
      --endpoint-url http://localhost:4566
      --attribute-definitions AttributeName=pk,AttributeType=S
      --key-schema AttributeName=pk,KeyType=HASH
      --billing-mode PAY_PER_REQUEST
      --region us-west-2
      --stream-specification StreamEnabled=true,StreamViewType=NEW_AND_OLD_IMAGES"
awslocal $payment_transactions_table_definition


ledger_transactions_table_definition="
      dynamodb create-table
      --table-name=ledger_transactions
      --endpoint-url http://localhost:4566
      --attribute-definitions AttributeName=pk,AttributeType=S AttributeName=sk,AttributeType=S
      --key-schema AttributeName=pk,KeyType=HASH AttributeName=sk,KeyType=RANGE
      --billing-mode PAY_PER_REQUEST
      --region us-west-2"
awslocal $ledger_transactions_table_definition

echo Listing Tables ...
awslocal dynamodb list-tables