package testpackage.book_store_servlet;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/kids-books")
public class KidsBooksPage extends CatalogPage {
    public void init()
    {
        String[] ids = { "lewis001", "alexander001", "rowling001" };
        setItems(ids);
        setTitle("All-Time Best Children's Fantasy Books");
    }
}