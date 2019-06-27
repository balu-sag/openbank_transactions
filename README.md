# Open Bank Transactions


# GIT
```sh
 $ git clone https://github.com/balu-sag/openbank_transactions.git
 $ cd openbank_transactions
 ```

# Installation
```sh
$ mvn spring-boot:run
```

# Test
```sh
$ mvn test
```

# Curl

```sh
$ curl http://localhost:8080/accounts/savings-kids-john/transactions
```

# Docker

```sh
$ docker build -t obp/transactions .
$ docker run -p 8080:8080 obp/transactions
```