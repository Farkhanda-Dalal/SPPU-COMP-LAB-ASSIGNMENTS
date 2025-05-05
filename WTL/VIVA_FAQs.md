### **1. Difference Between HTML and HTML5**

* **HTML (HyperText Markup Language)** is the standard language used for creating web pages. It's been around for decades and has evolved with new versions.

  * **HTML4**: Lacked native support for multimedia and other modern features.
* **HTML5**: The latest version of HTML, introduced many new features:

  * Native support for **audio**, **video** (`<audio>`, `<video>`), and **canvas** (`<canvas>`).
  * New semantic tags like `<header>`, `<footer>`, `<article>`, `<section>`, `<nav>`, etc.
  * **Local storage** for storing data locally in the browser (`localStorage`, `sessionStorage`).
  * Improved support for mobile and web apps.
  * **WebSockets** for real-time communication.
  * **Offline capabilities** via service workers.

---

### **2. What are Struts?**

**Struts** is a popular open-source web framework for Java, built around the **MVC (Model-View-Controller)** design pattern. It helps in developing scalable and maintainable web applications.

* **Model**: Represents data or business logic.
* **View**: Represents the UI (HTML).
* **Controller**: Processes user input, handles business logic, and updates the view.

**Struts** provides various reusable components and tools for Java web development, like:

* **ActionServlet**: Main controller.
* **Action**: A class where business logic is implemented.

---

### **3. What are Frames?**

Frames refer to an old HTML element (`<frameset>`) that allowed a webpage to be split into multiple scrollable sections or panels. Each section could load a different document. Frames were mostly used in older web designs for navigation.

* **Syntax**:

  ```html
  <frameset cols="25%, 75%">
    <frame src="nav.html">
    <frame src="content.html">
  </frameset>
  ```

**Note**: Frames are now considered obsolete in HTML5 and are replaced by **iframes** (`<iframe>`) or CSS grid/flexbox for layout.

---

### **4. What is User State?**

User state refers to information about the user that is stored and maintained during their interaction with a web application. The purpose is to provide a personalized experience and remember user actions across requests.

Common techniques to manage user state:

* **Cookies**: Small data stored in the browser.
* **Session Storage**: Stores data only for the duration of the page session.
* **Local Storage**: Data persists across sessions.
* **Server-side session**: Data stored on the server, identified by a session ID.

---

### **5. What are Cookies?**

Cookies are small pieces of data stored on the client's browser that help in tracking state across requests. They are mainly used for session management (e.g., logging in) and tracking user preferences.

* **Setting a cookie**:

  ```javascript
  document.cookie = "username=JohnDoe";
  ```

* **Accessing a cookie**:

  ```javascript
  let x = document.cookie;
  ```

Cookies have **expiration dates** and can be configured with `HttpOnly`, `Secure`, and `SameSite` flags to enhance security.

---

### **6. What is an Alert/Prompt Box?**

* **Alert Box**: Displays a message to the user and waits for them to acknowledge it (click "OK").

  ```javascript
  alert("This is an alert box!");
  ```

* **Prompt Box**: Displays a message and allows the user to input a value.

  ```javascript
  var userName = prompt("Enter your name:", "Guest");
  alert("Hello, " + userName);
  ```

---

### **7. Difference Between Servlet and Struts**

* **Servlet**: A Java class used to handle HTTP requests in a web application. It is the building block of Java web applications.

  * Example: `HttpServlet` class processes GET/POST requests.

* **Struts**: A framework that builds on servlets and provides additional functionality using the **MVC pattern**. It simplifies complex web applications by introducing reusable components.

---

### **8. What is DOM?**

**DOM (Document Object Model)** is an interface that provides a structured representation of an HTML document, allowing programs to manipulate its structure, style, and content.

* The **DOM tree** starts from a root (the document itself) and branches out to its elements (tags, text, attributes).

Example of accessing DOM:

```javascript
let element = document.getElementById("header");
element.style.color = "blue"; // Changes the color of the header
```

---

### **9. CSS Selectors**

CSS selectors are patterns used to select elements on an HTML page and apply styles to them.

Types of selectors:

* **Universal Selector**: `*` (applies to all elements).

  ```css
  * { color: red; }
  ```
* **ID Selector**: `#id` (selects an element with a specific ID).

  ```css
  #header { font-size: 24px; }
  ```
* **Class Selector**: `.class` (selects all elements with a specific class).

  ```css
  .box { margin: 20px; }
  ```
* **Element Selector**: `element` (selects all elements of a specific type).

  ```css
  p { line-height: 1.5; }
  ```

---

### **10. What is AJAX?**

**AJAX (Asynchronous JavaScript and XML)** is a technique used to update parts of a web page without reloading the entire page.

* It uses the `XMLHttpRequest` object or the modern `fetch()` API to send asynchronous requests to the server and update the webpage with the response.

Example with `fetch`:

```javascript
fetch('/data')
  .then(response => response.json())
  .then(data => {
    document.getElementById("result").innerText = data.name;
  });
```

---

### **11. Types of CSS**

1. **Inline CSS**: Applied directly to an HTML element using the `style` attribute.

   ```html
   <div style="color: red;">Hello</div>
   ```

2. **Internal CSS**: Defined inside the `<style>` tag within the `<head>` section.

   ```html
   <style>
     p { color: green; }
   </style>
   ```

3. **External CSS**: Defined in an external file linked to the HTML document.

   ```html
   <link rel="stylesheet" href="styles.css">
   ```

---

### **12. Different Angular Directives**

* **Structural Directives**: These modify the structure of the DOM.

  * `*ngIf`: Conditionally adds/removes elements.
  * `*ngFor`: Loops over a list and renders each item.

* **Attribute Directives**: These modify the appearance or behavior of an element.

  * `ngClass`: Dynamically applies CSS classes.
  * `ngStyle`: Dynamically applies styles.

* **Custom Directives**: User-defined directives to add custom behavior to elements.

---

### **13. What are JavaBeans?**

JavaBeans are reusable components that encapsulate multiple objects into a single object (a bean). A JavaBean follows specific conventions:

* It has a **no-argument constructor**.
* It uses **getter and setter methods** to access its properties.

Example:

```java
public class Student {
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
```

---

### **14. How are Variables Declared in PHP?**

In PHP, variables are prefixed with a dollar sign (`$`).

Example:

```php
$variable = "Hello, World!";
```

---

### **15. What is ASP.NET?**

**ASP.NET** is a web application framework developed by Microsoft. It allows developers to build dynamic websites, web applications, and services using languages like C# or VB.NET.

---

### **16. What is Ruby on Rails?**

**Ruby on Rails** is an open-source web application framework written in Ruby. It follows the **MVC** architecture and provides tools to create full-stack web applications quickly and efficiently.

---

### **17. Servlet Project Directory Structure**

```
/WebApp
  ├── WEB-INF/
  │     ├── web.xml  # Deployment descriptor
  │     └── classes/ # Compiled Java classes
  └── index.html
```

---

### **18. Types of Arrays in JavaScript and PHP**

**JavaScript Arrays**:

```js
let arr = [1, 2, 3];  // Indexed array
let obj = {name: "John", age: 30};  // Associative (object)
```

**PHP Arrays**:

```php
$indexed = array(1, 2, 3);
$assoc = array("name" => "John", "age" => 30);
$multi = array(array(1, 2), array(3, 4));
```

---

### **19. Difference Between JSP and Servlet**

* **Servlet**: A Java class for processing HTTP requests directly.
* **JSP**: A page that mixes HTML and Java to create dynamic content, which is converted to a servlet during compilation.

---

### **20. JSP Tags**

* **Scriptlet**: `<% %>`: Java code within HTML.

  ```jsp
  <% int num = 10; %>
  ```
* **Expression**: `<%= %>`: Outputs a result to the page.

  ```jsp
  <%= "Hello World" %>
  ```

---

### **21. JSP Lifecycle Methods**

* **jspInit()**: Called when the JSP is initialized.
* **\_jspService()**: Handles the HTTP request.
* **jspDestroy()**: Called when the JSP is destroyed.

---

### **22. Methods Created After Converting JSP to Servlet**

* **\_jspService(HttpServletRequest req, HttpServletResponse res)**: Handles the request.

---

### **23. Classes in Servlet and Their Function**

* **HttpServlet**: The base class for handling HTTP requests.
* **HttpServletRequest**: Represents the request.
* **HttpServletResponse**: Represents the response.
* **ServletConfig**: Provides servlet initialization parameters.
* **ServletContext**: Provides application-wide settings.

---

### **24. Ruby on Rails Code Example**

```ruby
class ProductsController < ApplicationController
  def index
    @products = Product.all
  end
end
```

---

### **25. How to Run PHP Assignment**

1. Install a local server (XAMPP, WAMP, LAMP).
2. Save the file in the server's root directory (`htdocs` in XAMPP).
3. Open a browser and navigate to `http://localhost/yourfile.php`.

---
