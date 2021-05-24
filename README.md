# Requirements
* JDK-8
* Mysql-5.7.22

# Setup
* Install the mentioned version of mysql.
* An alternative approach would be to use Docker to setup a mysql environment in your system. To do this, use the command  
>`docker run -d --rm -p <host port>:3306 -e MYSQL_ROOT_PASSWORD=<database password> -e MYSQL_DATABASE=<database name> -v [project directory]:/var/lib/mysql --name mysql mysql:5.7.2`
* This Docker command is used to set up a container with a mysql image.
* Database name, password and the port can be changed in `application.yml`

# API
* The API functions based on the specified endpoints. 
* The `/add` endpoint is used for the POST method.
    * The input is a JSON object
    ```json
    {
        "centerName": text,
        "centerCode": text,
        "address": {
            "detailedAddress": text,
            "city": text,
            "state": text,
            "pinCode": text
        },
        "studentCapacity": number,
        "cousesOffered": {list<text>}
    }
* The `/list` endpoint is used for the GET method.
* When the GET method is invoked the contents of the table are displayed in a JSON object. 
