# Read Me

The original ide is from  
https://erkanyasun.medium.com/implementing-spring-boot-3-x-with-graphql-for-efficient-data-fetching-0f5335be91e0

Go to
http://localhost:8080/graphiql

Run

```
query {
  books {
    id
    title
    author
  }
}
```

or

```
mutation {
  addBook(title: "GraphQL Book", author: "Author Name", publisher: "Publisher Name", price: 29.99) {
    id
    title
  }
}
```

# curl

```
curl -X POST http://localhost:8080/graphql -H "Content-Type: application/json" -d "{\"query\": \"mutation { addBook(title: \\\"New Book\\\", author: \\\"New Author\\\", publisher: \\\"New Publisher\\\", price: 19.99) { id title author } }\"}"

```

or

```
curl -X POST http://localhost:8080/graphql -H "Content-Type: application/json" -d "{\"query\": \"query { books { id title author } }\"}"
```