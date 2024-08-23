echo Creating DynamoDb Tables ...

kanap_accounts_table_definition="
      dynamodb create-table
      --table-name=kanap_accounts
      --endpoint-url http://localhost:4566
      --attribute-definitions AttributeName=pk,AttributeType=S AttributeName=sk,AttributeType=S
      --key-schema AttributeName=pk,KeyType=HASH AttributeName=sk,KeyType=RANGE
      --billing-mode PAY_PER_REQUEST
      --region us-west-2"
awslocal $kanap_accounts_table_definition

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

kanap_transactions_table_definition="
      dynamodb create-table
      --table-name=kanap_transactions
      --endpoint-url http://localhost:4566
      --attribute-definitions AttributeName=pk,AttributeType=S AttributeName=sk,AttributeType=S
      --key-schema AttributeName=pk,KeyType=HASH AttributeName=sk,KeyType=RANGE
      --billing-mode PAY_PER_REQUEST
      --region us-west-2"
awslocal $kanap_transactions_table_definition

transaction_info_table_definition="
      dynamodb create-table
      --table-name=TransactionInfo
      --endpoint-url http://localhost:4566
      --attribute-definitions AttributeName=transaction_id,AttributeType=S
      --key-schema AttributeName=transaction_id,KeyType=HASH
      --billing-mode PAY_PER_REQUEST
      --region us-west-2"
awslocal $transaction_info_table_definition

transaction_info_table_definition="
      dynamodb create-table
      --table-name TransactionInfo
      --attribute-definitions AttributeName=transaction_id,AttributeType=S
      --key-schema AttributeName=transaction_id,KeyType=HASH
      --billing-mode PAY_PER_REQUEST
      --region us-west-2"
$transaction_info_table_definition


echo Listing Tables ...
awslocal dynamodb list-tables

echo Inserting Data into TransactionInfo Table ...

insert_data="
      dynamodb put-item
      --table-name=TransactionInfo
      --endpoint-url http://localhost:4566
      --item='{
        \"transaction_id\": {\"S\": \"12345\"},
        \"transaction_type\": {\"S\": \"Credit\"},
        \"currency\": {\"S\": \"USD\"},
        \"status\": {\"S\": \"Completed\"}
      }'"
awslocal $insert_data

insert_data="
      dynamodb put-item
      --table-name=TransactionInfo
      --endpoint-url http://localhost:4566
      --item='{
        \"transaction_id\": {\"S\": \"67890\"},
        \"transaction_type\": {\"S\": \"Debit\"},
        \"currency\": {\"S\": \"EUR\"},
        \"status\": {\"S\": \"Pending\"}
      }'"
awslocal $insert_data

insert_data="
      dynamodb put-item
      --table-name TransactionInfo
      --item='{
        \"transaction_id\": {\"S\": \"12345\"},
        \"transaction_type\": {\"S\": \"Credit\"},
        \"currency\": {\"S\": \"USD\"},
        \"status\": {\"S\": \"Completed\"}
      }'"
awslocal $insert_data


echo Data Inserted.