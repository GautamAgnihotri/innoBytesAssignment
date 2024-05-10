// add book section starts ==>
const addBookForm = document.getElementById('addBookForm');


addBookForm.addEventListener('submit', async event => {
    event.preventDefault();

    const data = new FormData(addBookForm);

    console.log(Array.from(data));
//
    try {
        const res = await fetch(
            'http://127.0.0.1:8080/api/books',
            {
                method: 'POST',
                body: JSON.stringify(data),
            },
        );

        const resData = await res.json();
        alert("Book Successfully added!");
        console.log(resData);
    } catch (err) {
        alert("Error Occured! "+err.message);
        console.log(err.message);
    }
    console.log("form submitted")
});

// add book section ends

// book search section starts ==>

const bookSearchForm = document.getElementById('bookSearchForm');

bookSearchForm.addEventListener('submit', async event => {
    event.preventDefault();

     const data = new FormData(bookSearchForm);

     console.log(data.get("id"));
 
    try {
        const res = await fetch(
            'http://127.0.0.1:8080/api/books/'+data.get("id"),
            {
                method: 'Get',
                
            },
        );

        const resData = await res.json();
        displayBookSearchResult(resData)
       
        console.log(resData);
    } catch (err) {
        alert("Book not Found! Check book id again ");
        document.getElementById("book-table-search").remove();
        console.log(err.message);
    }
     console.log("form submitted")

});
// book search section ends
function displayBookSearchResult(resData){
    let resultContainer = document.getElementById("search-Book-Container");
    delete resData["user"];
    var table = `<table id="book-table-search"> <tr>`;
    for(let key in resData){
        table += `<th>${key}</th>`
    }
    table += `</tr> <tr>`;
    for(let key in resData){
        table += `<td>${resData[key]}</td>`
    }
    table +=`</tr> </table>`
    resultContainer.innerHTML=table;
}

// book search section ends

// book update section starts


    const bookUpdateForm = document.getElementById('bookUpdateForm');
    let ResultBookData;

    bookUpdateForm.addEventListener('submit', async event => {
        event.preventDefault();
    
         const data = new FormData(bookUpdateForm);
    
         console.log(data.get("id"));
     
        try {
            const res = await fetch(
                'http://127.0.0.1:8080/api/books/'+data.get("id"),
                {
                    method: 'Get',
                    
                },
            );
    
            ResultBookData = await res.json();
            displayResult(ResultBookData)
           
            console.log(ResultBookData);
        } catch (err) {
            alert("Book not Found! Check book id again ");
            // document.getElementById("book-table-update").remove();
            console.log(err.message);
        }
         console.log("form submitted")
    
    });
    // book search section ends
    function displayResult(resData){
        let resultContainer = document.getElementById("update-book-container");
        delete resData["user"];
        var table = `<table id="book-table-update"> <tr>`;
        for(let key in resData){
            table += `<th>${key}</th>`
        }
        table += `</tr> <tr>`;
        for(let key in resData){
            table += `<td>${resData[key]}</td>`
        }
        table +=`<td id="edit-link"onclick=displayEditBook()><strong> edit </strong></td>`
        table +=`</tr> </table>`
        resultContainer.innerHTML=table;
    }

    function displayEditBook(){
         const editBookElement = document.getElementById("editBook");
        editBookElement.style.display="flex";
        document.getElementById("editBookId").value=ResultBookData["id"];
         document.getElementById("editBookTitle").value=ResultBookData["title"];
         document.getElementById("editBookAuthor").value=ResultBookData["author"];
         document.getElementById("editBookCost").value=ResultBookData["cost"];
         document.getElementById("editBookQuantity").value=ResultBookData["quantity"];
//         editBookElement.style.display = 'block';

    }
// edit book request section starts
// const editBookForm = document.getElementById("EditBookForm");

// editBookForm.addEventListener('submit', async event => {
//     console.log("Edit Book log success")
//     event.preventDefault();
//     const data = new FormData();
//     data.append("id",document.getElementById("editBookId").value);
//     data.append("title",document.getElementById("editBookTitle").value);
//     data.append("author",document.getElementById("editBookAuthor").value);
//     data.append("cost",document.getElementById("editBookCost").value);
//     data.append("quantity",document.getElementById("editBookQuantity").value);
//     console.log(data);
//     try {
//         const res = await fetch(
//             'http://127.0.0.1:8080/api/books/edit/'+data.get("id"),
//     {
//         method: 'PUT',
//         body: data
//     }
//     );
//     if (res.ok) {
//         alert("Book updated successfully");
//     } else {
//         alert("Book not Found! Check book id again ");
//     }
// } catch (err) {
//     alert("Error: " + err.message);
//     console.log(err.message);
// }
// })
// edit book request section ends
// book update section ends
