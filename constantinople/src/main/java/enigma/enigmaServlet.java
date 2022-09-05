package enigma;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class enigmaServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		enigmaServlet servlet = new enigmaServlet();
		
		String codeword = servlet.clean(req.getParameter("codeword"));		
		int dayOfMonth = servlet.cleanDay(req.getParameter("dayOfMonth"));
		String message = servlet.cleanMessage(req.getParameter("message"));
		String encodeOrDecode = (req.getParameter("method"));
		
		TakeInput userInput = new TakeInput();
		String Ouput = userInput.takeInput(codeword, dayOfMonth, message, encodeOrDecode);
		
			
		PrintWriter out=res.getWriter();		
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		out.println("");
		out.println("<style>");
		out.println("* {");
		out.println("  box-sizing: border-box;");
		out.println("}");
		out.println("");
		out.println("input[type=text], textarea {");
		out.println("  width: 100%;");
		out.println("  padding: 12px;");
		out.println("  border: 1px solid #ccc;");
		out.println("  border-radius: 4px;");
		out.println("  resize: vertical;");
		out.println("  font-family: courier;");
		out.println("  font-size: 25px;");
		out.println("}");
		out.println("");
		out.println("input[type=text], select {");
		out.println("  width: 100%;");
		out.println("  padding: 12px;");
		out.println("  border: 1px solid #ccc;");
		out.println("  border-radius: 4px;");
		out.println("  resize: vertical;");
		out.println("}");
		out.println("");
		out.println("label {");
		out.println("  padding: 12px 12px 12px 0;");
		out.println("  display: inline-block;");
		out.println("}");
		out.println("");
		out.println("input[type=submit] {");
		out.println("  background-color: #04AA6D;");
		out.println("  color: white;");
		out.println("  padding: 12px 20px;");
		out.println("  border: none;");
		out.println("  border-radius: 4px;");
		out.println("  cursor: pointer;");
		out.println("  float: center;");
		out.println("}");
		out.println("");
		out.println("input[type=submit]:hover {");
		out.println("  background-color: #45a049;");
		out.println("}");
		out.println("");
		out.println(".container {");
		out.println("  border-radius: 5px;");
		out.println("  background-color: #f3f2f2;");
		out.println("  padding: 20px;");
		out.println("}");
		out.println("");
		out.println(".col-25 {");
		out.println("  float: left;");
		out.println("  width: 25%;");
		out.println("  margin-top: 6px;");
		out.println("}");
		out.println("");
		out.println(".col-75 {");
		out.println("  float: center;");
		out.println("  width: 75%;");
		out.println("  margin-top: 6px;");
		out.println("}");
		out.println("");
		out.println("/* Clear floats after the columns */");
		out.println(".row:after {");
		out.println("  content: \"\";");
		out.println("  display: table;");
		out.println("  clear: both;");
		out.println("}");
		out.println("");
		out.println("/* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */");
		out.println("@media screen and (max-width: 600px) {");
		out.println("  .col-25, .col-75, input[type=submit] {");
		out.println("    width: 100%;");
		out.println("    margin-top: 0;");
		out.println("  }");
		out.println("}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body><center>");
		out.println("<div class=\"container\">");
		out.println("    <div class=\"row\">");
		out.println("      <div class=\"col-15\">        ");
		out.println("      </div>");
		out.println("      <h2 style=\"font-family:papyrus;\">Your message has been coded. . .</h2>");
		out.println("    <div class=\"row\">");
		out.println("      <div class=\"col-15\">       ");
		out.println("      </div>");
		out.println("      <div class=\"col-75\">");		
		out.println("        <textarea id=\"answer\" name=\"answer\" style=\"height:200px\">");		
		out.print(Ouput);		
		out.println("</textarea>");
		out.println("      </div>");
		out.println("    </div>");
		out.println("    <div class=\"row\">");
		out.println("      <div class=\"col-75\">");
		out.println("        <form action=/constantinople/index.jsp>");
		out.println("          <input type=submit value='Encode or Decode another message'>");
		out.println("        </form></center>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		
		
		
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();
        writer.println("<html><head><title>Order Information</title></head>");
		
	}
	
	public String clean(String string) {
		if (string == "") {
			return "constantinople";			
		}
		if (string.replaceAll("[^A-Za-z]", "").trim().toLowerCase().replace(" ", "") == "") {
			return "constantinople";
		}
		return (string.toLowerCase().replaceAll("[^A-Za-z]", ""));
	}
	
	public String cleanMessage(String string) {
		if (string == "") {
			return "";			
		}
		if (string.replaceAll("[^A-Za-z]", "").trim().toLowerCase().replace(" ", "") == "") {
			return "";
		}
		return (string.toLowerCase().replaceAll("[^A-Za-z]", ""));
	}
	
	public int cleanDay(String day) {
		if (day == "") {
			return 8;
		}
		try 
		{ 
			Integer.parseInt(day); 
			if (Integer.valueOf(day) > 0 && Integer.valueOf(day) < 32) {
				return Integer.valueOf(day);
			}
		}  
		catch (NumberFormatException e)  
		{ 
			return 8; 
		}
		return 8;
	}
	

}
