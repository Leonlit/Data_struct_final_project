Simple Library Book Borrowing simulation

Project concept:
- Books will be stored in a text file (we only need to change some data so database will be over-killing I think) 
- But the Book class will have the following attribute
    - id [integer]
    - name [string]
    - categories [string-array]
    - date [string_DD-MM-YYYY]
    - writer [string]
    - previously borrowed [graph]
    - waiting list [queue]

-Main Menu
|__Search book menu [search_and_tree_algorithm_(1-3)]
|   |__By categories (optional)
|   |__By name
|   |__By ID
|   |__Sort book [sorting_algorithm]
|   |   |__By id
|   |   |__By name
|   |   |__By categories (optional)
|   |
|   |__View Book detail based on ID
|   |__Add to cart (using id after searching for the book) [array/linkedlist]
|   |__View waiting list (if the book is borrowed by other student) [queue]
|   |__View previously who has borrowed them [graph]
|       |__Print the graph out [Kinda_important]
|
|__View cart [array/linkedlist]
|
|__Check out (clearning all cart item into "bag" array)
|
|__Exit