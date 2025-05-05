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






