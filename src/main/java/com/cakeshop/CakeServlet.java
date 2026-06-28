package com.cakeshop;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CakeServlet extends HttpServlet {

    private static final String[][] CAKES = {
        // name, description, emoji, bg, price, tag, category
        {"Chocolate Truffle",      "Rich dark chocolate ganache, moist cocoa sponge, chocolate shards on top.",        "🍫", "#f5e6e8", "₹1,299", "Bestseller",    "Signature"},
        {"Red Velvet Dream",       "Cream cheese frosting on our signature crimson velvet sponge.",                    "🎂", "#fce8ec", "₹1,199", "Fan Favourite", "Signature"},
        {"Mango Mousse",           "Light mango cream with Alphonso pulp. Best no-bake summer cake.",                  "🥭", "#fff3e0", "₹1,099", "Seasonal",      "Seasonal"},
        {"Black Forest",           "Kirsch-soaked cherries, fresh cream, dark chocolate shavings.",                    "🍒", "#f3e8f5", "₹1,249", "Classic",       "Signature"},
        {"Butterscotch Delight",   "Crunchy butterscotch praline inside a soft vanilla sponge.",                       "🍮", "#fff8e1", "₹1,149", "Comfort Pick",  "Signature"},
        {"Strawberry Shortcake",   "Fresh strawberries, whipped cream, light vanilla layers.",                         "🍓", "#ffeef2", "₹1,199", "Seasonal",      "Seasonal"},
        {"Tiramisu Cake",          "Espresso-soaked ladyfingers, mascarpone cream, dusted cocoa.",                     "☕", "#f0ebe3", "₹1,449", "Premium",       "Premium"},
        {"Lemon Drizzle",          "Zesty lemon curd filling, sharp glaze, soft citrus sponge.",                       "🍋", "#fffde7", "₹1,099", "Light",         "Seasonal"},
        {"Wedding Tier Cake",      "3-tier custom fondant cake. Price starts per tier. Call to discuss.",              "💍", "#fce8f0", "₹4,999", "Custom",        "Custom"},
        {"Photo Cake",             "Your favourite photo printed on edible wafer paper over fresh cream.",             "📸", "#e8f0fc", "₹1,599", "Custom",        "Custom"},
        {"Cheesecake Classic",     "New York-style baked cheesecake with a buttery graham cracker base.",              "🧀", "#fffde7", "₹1,349", "Premium",       "Premium"},
        {"Ferrero Rocher Cake",    "Hazelnut praline cream, whole Ferrero Rochers, gold-dusted exterior.",             "🌰", "#f5efe6", "₹1,699", "Indulgent",     "Premium"},
    };

    private static final String[] CATEGORIES = {"All", "Signature", "Seasonal", "Premium", "Custom"};

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String filter = request.getParameter("category");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html><html lang='en'><head>");
        out.println("<meta charset='UTF-8'/><meta name='viewport' content='width=device-width,initial-scale=1.0'/>");
        out.println("<title>Our Cakes — Crumbs &amp; Co.</title>");
        out.println("<link href='https://fonts.googleapis.com/css2?family=Playfair+Display:ital,wght@0,400;0,600;1,400&family=Lato:wght@300;400&display=swap' rel='stylesheet'/>");
        out.println("<style>");
        out.println("  *,*::before,*::after{margin:0;padding:0;box-sizing:border-box}");
        out.println("  :root{--rose:#d4708a;--blush:#f7e8ec;--mocha:#4a2c2a;--caramel:#c98b5a;--cream:#fdf8f5;--mist:#f0e6e9}");
        out.println("  body{background:var(--cream);color:var(--mocha);font-family:'Lato',sans-serif;font-weight:300}");
        out.println("  nav{position:fixed;top:0;width:100%;z-index:100;display:flex;align-items:center;justify-content:space-between;padding:1.2rem 3rem;background:rgba(253,248,245,0.95);backdrop-filter:blur(8px);border-bottom:1px solid var(--mist)}");
        out.println("  .nav-logo{font-family:'Playfair Display',serif;font-size:1.6rem;color:var(--mocha);text-decoration:none}");
        out.println("  .nav-logo span{color:var(--rose);font-style:italic}");
        out.println("  .nav-links{display:flex;gap:2.2rem;list-style:none}");
        out.println("  .nav-links a{text-decoration:none;color:var(--mocha);font-size:0.82rem;letter-spacing:0.1em;text-transform:uppercase;transition:color 0.2s}");
        out.println("  .nav-links a:hover{color:var(--rose)}");
        out.println("  .page-hero{background:var(--blush);padding:9rem 3rem 4rem;text-align:center}");
        out.println("  .page-eyebrow{font-size:0.72rem;letter-spacing:0.35em;text-transform:uppercase;color:var(--caramel);margin-bottom:0.8rem}");
        out.println("  .page-title{font-family:'Playfair Display',serif;font-size:clamp(2.5rem,5vw,4rem);font-weight:400;margin-bottom:0.8rem}");
        out.println("  .page-sub{color:#7a5c5a;font-size:0.95rem;max-width:44ch;margin:0 auto}");
        out.println("  .page-body{padding:3rem}");
        out.println("  .filter-bar{display:flex;gap:0.7rem;flex-wrap:wrap;margin-bottom:3rem;justify-content:center}");
        out.println("  .filter-btn{padding:0.55rem 1.6rem;border:1px solid var(--mist);text-decoration:none;color:var(--mocha);font-size:0.75rem;letter-spacing:0.12em;text-transform:uppercase;border-radius:30px;transition:all 0.2s;background:#fff}");
        out.println("  .filter-btn:hover,.filter-btn.active{background:var(--rose);color:#fff;border-color:var(--rose)}");
        out.println("  .cake-grid{display:grid;grid-template-columns:repeat(auto-fill,minmax(260px,1fr));gap:2rem}");
        out.println("  .cake-card{background:#fff;border-radius:8px;overflow:hidden;box-shadow:0 4px 20px rgba(74,44,42,0.06);transition:transform 0.3s,box-shadow 0.3s;cursor:pointer}");
        out.println("  .cake-card:hover{transform:translateY(-6px);box-shadow:0 16px 40px rgba(74,44,42,0.14)}");
        out.println("  .cake-card:hover .cake-emoji{transform:scale(1.12) rotate(-4deg)}");
        out.println("  .cake-img{height:200px;display:flex;align-items:center;justify-content:center;font-size:5.5rem}");
        out.println("  .cake-emoji{display:inline-block;transition:transform 0.4s}");
        out.println("  .cake-body{padding:1.4rem}");
        out.println("  .cake-name{font-family:'Playfair Display',serif;font-size:1.15rem;margin-bottom:0.3rem}");
        out.println("  .cake-desc{font-size:0.82rem;color:#9a7a78;line-height:1.6;margin-bottom:1rem}");
        out.println("  .cake-footer{display:flex;align-items:center;justify-content:space-between}");
        out.println("  .cake-price{font-family:'Playfair Display',serif;font-size:1.2rem;color:var(--rose)}");
        out.println("  .cake-tag{font-size:0.65rem;letter-spacing:0.12em;text-transform:uppercase;background:var(--blush);color:var(--rose);padding:0.25rem 0.7rem;border-radius:20px}");
        out.println("  .order-btn{display:block;width:100%;margin-top:1rem;padding:0.75rem;background:var(--rose);color:#fff;border:none;border-radius:4px;font-family:'Lato',sans-serif;font-size:0.78rem;letter-spacing:0.15em;text-transform:uppercase;cursor:pointer;transition:background 0.2s}");
        out.println("  .order-btn:hover{background:var(--mocha)}");
        out.println("  .empty{text-align:center;padding:4rem;color:#9a7a78;font-family:'Playfair Display',serif;font-size:1.5rem}");
        out.println("  footer{background:var(--mocha);color:rgba(255,255,255,0.45);padding:3rem;text-align:center;font-size:0.8rem;margin-top:4rem}");
        out.println("  footer .footer-logo{font-family:'Playfair Display',serif;font-size:1.8rem;color:#fff;display:block;margin-bottom:0.8rem;font-style:italic}");
        out.println("  @media(max-width:768px){nav{padding:1.2rem 1.5rem}.nav-links{display:none}.page-body{padding:2rem 1.5rem}}");
        out.println("</style></head><body>");

        // NAV
        out.println("<nav>");
        out.println("  <a class='nav-logo' href='/cake_app_java/'>Crumbs <span>&</span> Co.</a>");
        out.println("  <ul class='nav-links'>");
        out.println("    <li><a href='/cake_app_java/'>Home</a></li>");
        out.println("    <li><a href='/cake_app_java/cakes'>Our Cakes</a></li>");
        out.println("    <li><a href='/cake_app_java/cakes?category=Custom'>Custom Orders</a></li>");
        out.println("  </ul>");
        out.println("</nav>");

        // PAGE HERO
        out.println("<div class='page-hero'>");
        out.println("  <p class='page-eyebrow'>Baked Fresh Daily</p>");
        out.println("  <h1 class='page-title'>Our Cake Menu 🎂</h1>");
        out.println("  <p class='page-sub'>Every cake hand-crafted to order. Select a category or browse the full menu below.</p>");
        out.println("</div>");

        out.println("<div class='page-body'>");

        // FILTER BAR
        out.println("  <div class='filter-bar'>");
        for (String cat : CATEGORIES) {
            boolean active = (cat.equals("All") && filter == null) || cat.equals(filter);
            String href = cat.equals("All") ? "/cake_app_java/cakes" : "/cake_app_java/cakes?category=" + cat;
            out.println("    <a href='" + href + "' class='filter-btn" + (active ? " active" : "") + "'>" + cat + "</a>");
        }
        out.println("  </div>");

        // CAKE GRID
        out.println("  <div class='cake-grid'>");
        int count = 0;
        for (String[] c : CAKES) {
            if (filter != null && !filter.equals(c[6])) continue;
            count++;
            out.println("  <div class='cake-card'>");
            out.println("    <div class='cake-img' style='background:" + c[3] + "'><span class='cake-emoji'>" + c[2] + "</span></div>");
            out.println("    <div class='cake-body'>");
            out.println("      <div class='cake-name'>" + c[0] + "</div>");
            out.println("      <div class='cake-desc'>" + c[1] + "</div>");
            out.println("      <div class='cake-footer'>");
            out.println("        <span class='cake-price'>" + c[4] + "</span>");
            out.println("        <span class='cake-tag'>" + c[5] + "</span>");
            out.println("      </div>");
            out.println("      <button class='order-btn'>Order Now</button>");
            out.println("    </div>");
            out.println("  </div>");
        }
        if (count == 0) {
            out.println("  <div class='empty' style='grid-column:1/-1'>No cakes in this category yet. 🎂</div>");
        }
        out.println("  </div>");
        out.println("</div>");

        out.println("<footer><span class='footer-logo'>Crumbs &amp; Co.</span>&copy; 2025 Crumbs &amp; Co. Artisan Bakery &nbsp;|&nbsp; Running on Apache Tomcat 9 via Docker</footer>");
        out.println("</body></html>");
    }
}
