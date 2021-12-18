# CSV-reader-spring-project

1-api to uploadCSV
curl --location --request POST 'localhost:8082/uploadCSV' \
--header 'Content-Type: application/csv' \
--header 'Content-disposition: attachment; filename=Product.csv' \
--form 'file=@"/C:/Users/ptilara/Downloads/Product.csv"'

2- api to search on the basic of name
curl --location --request GET 'localhost:8082/searchMedicine/med_para'

3- api to get all the medicine list 
curl --location --request GET 'localhost:8082/'

4- api to get details on the basic of Unique code
curl --location --request GET 'localhost:8082/getMedicineDetails/5996'

5- api to add new entry 
curl --location --request POST 'localhost:8082/placeOrder' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "med_para123",
    "batchNumber":"12sBa",
    "expiryDate":"30/12/2021",
    "balanceQty":123.11,
    "packaging":"normal",
    "schemes":"scas",
    "mrp":1212.1,
    "manufacturer":"dr labs",
    "hsnCode":"aass"
}'
