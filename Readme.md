#Book API

| Method HTTP |	Address | What do it |
|---|---|---|
|GET | /books | Return list of books. |
|POST |	/books | Create new book based on the JSON structure. |
|GET | /books/{id} | Displaying book information by id. |
|PUT | /books |	Changing book information. |
|DELETE | /books/{id} |	Deleting book by id. |

###Default book JSON

>{\
>   "id": 1,\
>   "isbn": book isbn,\
>   "title": book title,\
>   "author": book author,\
>   "publisher": book publisher,\
>   "type": book type\
>}
