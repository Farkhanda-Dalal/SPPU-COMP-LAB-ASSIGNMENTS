### ✅ **Basic Servlet Hello World Code:**

```java
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html><body>");
        out.println("<h2>Hello, World from Servlet!</h2>");
        out.println("</body></html>");
    }
}
```

---
Here’s a simple **Servlet using `doPost()`** that takes user input (like name and email) from an HTML form and prints it:

---

### ✅ **HTML Form (example.html)**

```html
<form action="SubmitServlet" method="post">
  Name: <input type="text" name="username" /><br />
  Email: <input type="email" name="email" /><br />
  <input type="submit" value="Submit" />
</form>
```

---

### ✅ **Servlet Code (SubmitServlet.java)**

```java
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SubmitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get form data
        String name = request.getParameter("username");
        String email = request.getParameter("email");

        // Print the data
        out.println("<html><body>");
        out.println("<h2>Form Submitted Successfully</h2>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("</body></html>");
    }
}
```

---

### 🛠️ Setup Notes:

* Map servlet in `web.xml` or use annotation:

```java
@WebServlet("/SubmitServlet")
```

* Deploy to a servlet container like **Tomcat**.

Want this with database insertion too?


### 🔧 **Steps to Run This:**

1. **Save as** `HelloServlet.java`
2. Compile using `javac`
3. Deploy in a server like **Apache Tomcat** under `WEB-INF/classes`
4. Add entry in `web.xml`:

```xml
<servlet>
  <servlet-name>Hello</servlet-name>
  <servlet-class>HelloServlet</servlet-class>
</servlet>

<servlet-mapping>
  <servlet-name>Hello</servlet-name>
  <url-pattern>/hello</url-pattern>
</servlet-mapping>
```

Then access via:

```
http://localhost:8080/YourApp/hello
```

Need an example that also accepts form data?


### ✅ Simple Servlet: Fetch & Display Data from MySQL

```java
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class FetchDataServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // 1. Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Connect to DB
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/your_db", "root", "your_password");

            // 3. Query
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            // 4. Output
            out.println("<html><body><h2>Student List</h2>");
            while(rs.next()) {
                out.println("<p>" + rs.getString("name") + " - " + rs.getInt("age") + "</p>");
            }
            out.println("</body></html>");

            con.close();
        } catch(Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}
```

---
Here’s a simple **Java Servlet using `PreparedStatement`** to insert user data (like name and email) into a MySQL database securely:

---

### ✅ **HTML Form (form.html)**

```html
<form action="InsertServlet" method="post">
  Name: <input type="text" name="username" /><br />
  Email: <input type="email" name="email" /><br />
  <input type="submit" value="Submit" />
</form>
```

---

### ✅ **Servlet Code (InsertServlet.java)**

```java
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class InsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("username");
        String email = request.getParameter("email");

        try {
            // 1. Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Connect to Database
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/your_db", "root", "your_password");

            // 3. Prepare SQL Statement
            String query = "INSERT INTO users (name, email) VALUES (?, ?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, email);

            // 4. Execute
            int result = pst.executeUpdate();

            // 5. Output result
            if (result > 0) {
                out.println("<p>Data inserted successfully!</p>");
            } else {
                out.println("<p>Insertion failed.</p>");
            }

            con.close();
        } catch (Exception e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }
    }
}
```

---

### ✅ MySQL Table Example

```sql
CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  email VARCHAR(100)
);
```

---
Here’s a simple **Java Servlet** example that uses a `PreparedStatement` to **fetch data** (e.g., based on a username) from a MySQL database and display it:

---

### ✅ **HTML Form (search.html)**

```html
<form action="FetchServlet" method="post">
  Enter Name: <input type="text" name="username" />
  <input type="submit" value="Search" />
</form>
```

---

### ✅ **Servlet Code (FetchServlet.java)**

```java
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class FetchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("username");

        try {
            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to DB
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/your_db", "root", "your_password");

            // Prepare SQL to fetch data
            String query = "SELECT * FROM users WHERE name = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, name);

            ResultSet rs = pst.executeQuery();

            out.println("<html><body><h2>Search Result:</h2>");

            if (rs.next()) {
                String email = rs.getString("email");
                out.println("<p>Name: " + name + "</p>");
                out.println("<p>Email: " + email + "</p>");
            } else {
                out.println("<p>No user found with name: " + name + "</p>");
            }

            out.println("</body></html>");
            con.close();
        } catch (Exception e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }
    }
}
```

---
### *Servlet Project Directory*
MyWebApp/</br>
├── WebContent/ </br>
│   ├── WEB-INF/</br>
│   │   ├── web.xml                ← Deployment descriptor</br>
│   └── index.html / .jsp          ← Public HTML/JSP files</br>
│</br>
└── src/</br>
    └── com/</br>
        └── example/</br>
            └── MyServlet.java     ← Your Servlet class</br>

### How a Servlet is Processed (Servlet Life Cycle):

The servlet life cycle is managed by the **Servlet container** (like Apache Tomcat or Jetty), and it involves **three main stages**:

1. **Initialization (`init()` method):**

   * This happens only once when the servlet is first loaded.
   * The servlet container calls the `init()` method to initialize resources (like DB connections or config files).

2. **Request Handling (`service()` method):**

   * Every time a client (usually a browser) sends a request, the servlet container calls the `service()` method.
   * The `service()` method checks the request type (GET, POST, etc.) and calls the appropriate method: `doGet()`, `doPost()`, etc.
   * This is where the main logic of the servlet goes—processing input, calling business logic, and generating a response (like HTML or JSON).

3. **Destruction (`destroy()` method):**

   * When the server shuts down or the servlet is no longer needed, the `destroy()` method is called.
   * It cleans up resources like closing DB connections or stopping threads.

---

### **HttpServletRequest and HttpServletResponse with suitable examples.**

HttpServletRequest and HttpServletResponse are two core interfaces in the Servlet API that allow servlets to interact with clients (usually browsers) over the HTTP protocol.


| **HttpServletRequest** Method | **Purpose**                              | **Example**                        |
| ----------------------------- | ---------------------------------------- | ---------------------------------- |
| `getParameter(String name)`   | Gets form parameters or query parameters | `request.getParameter("username")` |
| `getHeader(String name)`      | Gets a specific HTTP header              | `request.getHeader("User-Agent")`  |
| `getCookies()`                | Gets cookies sent by the client          | `request.getCookies()`             |
| `getSession()`                | Retrieves the HttpSession object         | `request.getSession()`             |
| `getRemoteAddr()`             | Gets the IP address of the client        | `request.getRemoteAddr()`          |
| `getRequestURI()`             | Retrieves the URI of the request         | `request.getRequestURI()`          |

| **HttpServletResponse** Method         | **Purpose**                                        | **Example**                                       |
| -------------------------------------- | -------------------------------------------------- | ------------------------------------------------- |
| `setContentType(String type)`          | Sets the content type of the response              | `response.setContentType("text/html")`            |
| `getWriter()`                          | Gets a `PrintWriter` for writing the response body | `response.getWriter().println("Hello")`           |
| `sendRedirect(String location)`        | Redirects the client to another URL                | `response.sendRedirect("login.html")`             |
| `addCookie(Cookie cookie)`             | Adds a cookie to the response                      | `response.addCookie(new Cookie("user", "Alice"))` |
| `setStatus(int sc)`                    | Sets the HTTP status code of the response          | `response.setStatus(HttpServletResponse.SC_OK)`   |
| `setHeader(String name, String value)` | Sets an HTTP header in the response                | `response.setHeader("Cache-Control", "no-cache")` |

---







