package testpackage.book_store_servlet;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/tech-books")
public class TechBooksPage extends CatalogPage
{
    public void init()
    {
        String[] ids = { "hall001", "hall002" };
        setItems(ids);
        setTitle("All-Time Best Computer Books");
    }
}
