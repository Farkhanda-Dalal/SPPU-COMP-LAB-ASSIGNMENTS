### **1) What is CSS? What are the different ways to create CSS?**

**CSS (Cascading Style Sheets)** is used to describe the presentation (layout, colors, fonts, spacing) of HTML documents.
**Three ways to include CSS:**

* **Inline CSS:** Written inside the HTML element using the `style` attribute.

  ```html
  <p style="color:blue;">Text</p>
  ```
* **Internal CSS:** Written inside a `<style>` tag in the `<head>` section of the HTML page.

  ```html
  <style>p { color: blue; }</style>
  ```
* **External CSS:** Written in a separate `.css` file and linked using `<link>` tag.

  ```html
  <link rel="stylesheet" href="styles.css">
  ```

---

### **2) What is JSON? Why use JSON over XML?**

**JSON (JavaScript Object Notation)** is a format used to store and exchange data, especially between server and client.
**Advantages over XML:**

* **Simpler syntax** and easy to read
* **Faster parsing** and processing
* **Less data size** (lightweight)
* **Easily integrates with JavaScript**

---

### **3) Differences Between HTML and HTML5 (Five Points)**

| HTML (Old)                              | HTML5 (New)                                        |
| --------------------------------------- | -------------------------------------------------- |
| Limited multimedia support              | `<audio>` and `<video>` tags introduced            |
| No semantic elements                    | Semantic tags like `<article>`, `<nav>`, `<canvas>` introduced |
| No local storage                        | Supports `localStorage` and `sessionStorage`       |
|VML, Silverlight were req for vector graphics | Vector graphics are an integral part as SVG and Canvas are provided                       |
| Charset declaration and Doctype Declaration is difficult| Charset declaration and Doctype Declaration is difficult|
|Geoloaction of user browser was difficult to get| JS Geolocation API helps in getting real time geo loaction|
|Did not allow JS to run in browser. JS runs in same thread as browser interface.| JS can run in background due to JS Web Worker API|

---

### **4) Design Issues in Web Development**

* **Cross-browser compatibility:** Website should work on Chrome, Firefox, Edge, etc.
* **Responsive design:** Should adjust to screen sizes (mobile, desktop).
* **Performance:** Page should load fast.
* **Accessibility:** Usable by people with disabilities.
* **Security:** Safe from attacks like XSS, CSRF, etc.

---

### **5) What is the purpose of HTTP?**

HTTP (HyperText Transfer Protocol) is the **communication protocol** used for transferring data (HTML, images, etc.) between **web browser (client)** and **web server**.

---

### **6) How does a Web Browser work?**

* User enters URL
* Browser sends a request to the server
* Server responds with HTML/CSS/JS
* Browser **parses the code**, constructs a DOM tree, and renders the page visually

---

### **7) Steps: Browser Requests a Page**

1. User types URL
2. Browser contacts DNS to get IP address
3. Browser sends **HTTP request** to server
4. Server processes request and sends **HTTP response** (webpage data)
5. Browser displays the web page after parsing HTML/CSS/JS

---

### **8) Definitions**

* **Website:** A collection of related web pages hosted under one domain.
* **Web Page:** A single HTML document that can be viewed in a browser.
* **Web Server:** A computer/application that delivers web pages via HTTP.
* **URL:** Uniform Resource Locator; the web address used to locate resources.
* **Home Page:** The main page or first page of a website.

---

### **9) Why is HTTP Stateless?**

HTTP is called **stateless** because **each request is independent** — the server doesn't remember previous interactions.
This makes it fast and scalable, but requires external tools (like cookies or sessions) to **maintain user state**.

---

### **10) Three HTTP Commands**

* **GET:** Retrieve data from server (e.g., viewing a page).
* **POST:** Send data to the server (e.g., form submission).
* **PUT:** Update existing resource/data on the server.

---

### **11) HTML Tags with Example**

Tags are keywords enclosed in `< >` used to define elements in HTML.
**Example:**

```html
<h1>Hello</h1> <!-- heading -->
<p>This is a paragraph.</p>
```

---

### **12) Five HTML Tags**

* `<h1>` to `<h6>` – Headings
* `<p>` – Paragraph
* `<img>` – Embeds an image
* `<a>` – Creates a hyperlink
* `<ul>` / `<ol>` – Lists (unordered/ordered)

---

### **13) How to Set Up Your Own Website (Basic Requirements)**

1. **Domain Name:** Your website address (e.g., mysite.com)
2. **Web Hosting:** A server to store your files
3. **Website Files:** HTML, CSS, JS code
4. **Upload Tools:** FTP software or hosting panel
5. **Optional:** Use website builders or CMS like WordPress for ease

---

### **14) HTML Page to Show Your Details**

```html
<!DOCTYPE html>
<html>
<head><title>About Me</title></head>
<body>
  <h1>About Me</h1>
  <p>Hello! I am a web tech student. I enjoy designing websites and learning new technologies. My interests include coding, exploring UI/UX, and participating in tech fests.</p>
  <img src="your-photo.jpg" alt="My Photo" width="200">
</body>
</html>
```

---

### **15) Differences: Internet Explorer vs Mozilla Firefox**

| Feature       | Internet Explorer           | Mozilla Firefox                    |
| ------------- | --------------------------- | ---------------------------------- |
| Speed         | Slower                      | Faster and optimized               |
| Security      | Less secure                 | Regular security updates           |
| Extensions    | Limited support             | Rich extension library             |
| Compatibility | Poor with new web standards | Excellent support                  |
| Platform      | Windows only                | Cross-platform (Windows/Linux/Mac) |

---
Here are **concise and slightly expanded answers** to questions 16–28, perfect for **viva preparation** in Web Technologies:

---

### **16) Need for XML (Extensible Markup Language)**

* XML is used to **store and transport data** in a structured, human-readable and machine-readable format.
* It is **platform-independent** and supports data sharing across different systems.
* Maintains **data hierarchy** using custom tags (unlike fixed tags in HTML).
* Useful in **web services, configuration files**, and for **data interchange** between server-client.

---

### **17) Strengths of XML Technology**

* **Self-descriptive:** Tags describe the data
* **Structured and hierarchical**
* **Platform & language independent**
* Supports **Unicode** (multi-language support)
* Can be **validated** using DTD or XML Schema
* Used in **AJAX, web services (SOAP), and RSS feeds** </br>

| Data Type        | Real-World Example            | XML Use                    |
|------------------|-------------------------------|----------------------------| 
| Semi-Structured  | Emails, chat logs, blog posts | ✅ Tags structure data     | 
| Unstructured     | Raw email content, PDFs       | ⚠️ Can wrap, not structure | 

| Feature                     | XML                                                             | HTML                                           |
| --------------------------- | --------------------------------------------------------------- | ---------------------------------------------- |
| **Data Storage**            | Designed to **store and transport data**                        | Designed to **display data**                   |
| **Custom Tags**             | Supports **user-defined tags** (e.g., `<price>`, `<author>`)    | Has **predefined tags** (e.g., `<p>`, `<div>`) |
| **Data Validation**         | Can be **validated** using DTD or XML Schema                    | No built-in validation rules                   |
| **Structured Data**         | Ideal for **semi-structured data** (like config, RSS, invoices) | Not suitable for structured data               |
| **Separation of Data/View** | Keeps **data separate from presentation**                       | Mixes content with presentation                |
| **Data Interchange**        | Commonly used in **APIs**, config files, web services           | Not used for data transfer                     |
| **Machine Readable**        | Easier for machines to parse and understand                     | Mainly for browsers to render UI               |


---

### **18) What are DTDs (Document Type Definition)?**

* A DTD defines the **structure and rules** for an XML document.
* It specifies what elements, attributes, and nesting are allowed.
* **Two types:** Internal (inside the XML file) and External (linked externally).
* It ensures the XML document is **valid**.

---

### **19) Internal vs External DTDs**

| Feature       | Internal DTD                | External DTD                        |
| ------------- | --------------------------- | ----------------------------------- |
| Location      | Defined inside the XML file | Defined in a separate `.dtd` file   |
| Syntax        | `<!DOCTYPE note [ ... ]>`   | `<!DOCTYPE note SYSTEM "note.dtd">` |
| Reusability   | Only for that file          | Can be reused in multiple files     |
| Modifiability | Easy to modify directly     | Needs external file access          |

---

### **20) XML Schema vs DTD**

* **XML Schema** (XSD) defines structure **using XML syntax**, unlike DTD which uses a separate format.
* Supports **data types** (int, string, boolean, etc.)
* Allows defining **restrictions** (e.g., maxLength)
* **More powerful & modern** than DTD
* XML Schema is namespace-aware; DTD is not.

---

### **21) What is XSLT (Extensible Stylesheet Language Transformations)?**

* XSLT is used to **transform XML data** into HTML, plain text, or another XML document.
* It uses templates and rules to process XML elements.

**Example:**

```xml
<!-- XML -->
<name>John</name>

<!-- XSLT -->
<xsl:template match="name">
  <h1><xsl:value-of select="."/></h1>
</xsl:template>
```

---

### **22) What is HTML? Do all HTML tags have end tags?**

* HTML (HyperText Markup Language) is used to **create web pages**.
* No, not all tags have end tags.
  Example: `<img>`, `<br>`, `<hr>` are **self-closing** tags.

---

### **23) Difference Between HTML Elements and Tags**

| Term    | Description                                                  | Example        |
| ------- | ------------------------------------------------------------ | -------------- |
| Tag     | Markup used to define element                                | `<p>`          |
| Element | Complete structure with opening and closing tags and content | `<p>Hello</p>` |

---

### **24) What is a Style Sheet? How to Create Multi-Colored Text?**

* A **style sheet** (CSS) is used to **style HTML elements**.
* To create multi-colored text:

```html
<span style="color:red;">Red</span>
<span style="color:blue;">Blue</span>
<span style="color:green;">Green</span>
```

---

### **25) Difference Between `<progress>` and `<meter>`**

| Tag          | Usage                                           | Example                                      |
| ------------ | ----------------------------------------------- | -------------------------------------------- |
| `<progress>` | Shows progress of a task (e.g., file upload)    | `<progress value="50" max="100"></progress>` |
| `<meter>`    | Shows value in a known range (e.g., fuel level) | `<meter value="0.6">60%</meter>`             |

---

### **26) New `<input>` Types in HTML5 for Validation**

* `email` – Validates email format
* `url` – Validates URL
* `number` – Accepts only numbers
* `date` – Date picker
* `tel` – Telephone input
* `range` – Slider input
* `color` – Color picker

---

### **27) HTML Code for Admission Form**

```html
<!DOCTYPE html>
<html>
<head><title>Admission Form</title></head>
<body>
  <h2>Admission Form</h2>
  <form>
    Name: <input type="text" name="name"><br><br>
    Email: <input type="email" name="email"><br><br>
    DOB: <input type="date" name="dob"><br><br>
    Gender:
    <input type="radio" name="gender" value="Male">Male
    <input type="radio" name="gender" value="Female">Female<br><br>
    Course:
    <select name="course">
      <option>B.Tech</option>
      <option>B.Sc</option>
      <option>B.Com</option>
    </select><br><br>
    Address:<br>
    <textarea rows="4" cols="30"></textarea><br><br>
    <input type="submit" value="Submit">
  </form>
</body>
</html>
```

---

### **28) Use of Static and Dynamic Web Pages**

* **Static Page:** Same for every user, written in HTML only.
  **Use:** Company info, brochure websites.
* **Dynamic Page:** Content changes with user input or server response (uses PHP, JS, etc.).
  **Use:** Login systems, dashboards, shopping sites.

---


