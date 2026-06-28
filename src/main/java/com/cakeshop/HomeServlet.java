package com.cakeshop;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("  <meta charset='UTF-8'/>");
        out.println("  <meta name='viewport' content='width=device-width, initial-scale=1.0'/>");
        out.println("  <title>Crumbs & Co. — Artisan Cake Shop</title>");
        out.println("  <link href='https://fonts.googleapis.com/css2?family=Playfair+Display:ital,wght@0,400;0,600;1,400&family=Lato:wght@300;400&display=swap' rel='stylesheet'/>");
        out.println("  <style>");
        out.println("    *, *::before, *::after { margin:0; padding:0; box-sizing:border-box; }");
        out.println("    :root {");
        out.println("      --rose:    #d4708a;");
        out.println("      --blush:   #f7e8ec;");
        out.println("      --mocha:   #4a2c2a;");
        out.println("      --caramel: #c98b5a;");
        out.println("      --cream:   #fdf8f5;");
        out.println("      --mist:    #f0e6e9;");
        out.println("      --display: 'Playfair Display', serif;");
        out.println("      --body:    'Lato', sans-serif;");
        out.println("    }");
        out.println("    html { scroll-behavior: smooth; }");
        out.println("    body { background: var(--cream); color: var(--mocha); font-family: var(--body); font-weight: 300; line-height: 1.6; }");

        // NAV
        out.println("    nav { position:fixed; top:0; width:100%; z-index:100; display:flex; align-items:center; justify-content:space-between; padding:1.2rem 3rem; background:rgba(253,248,245,0.95); backdrop-filter:blur(8px); border-bottom:1px solid var(--mist); }");
        out.println("    .nav-logo { font-family:var(--display); font-size:1.6rem; color:var(--mocha); text-decoration:none; letter-spacing:0.04em; }");
        out.println("    .nav-logo span { color:var(--rose); font-style:italic; }");
        out.println("    .nav-links { display:flex; gap:2.2rem; list-style:none; }");
        out.println("    .nav-links a { text-decoration:none; color:var(--mocha); font-size:0.82rem; letter-spacing:0.1em; text-transform:uppercase; transition:color 0.2s; }");
        out.println("    .nav-links a:hover { color:var(--rose); }");

        // HERO
        out.println("    .hero { min-height:100vh; display:grid; grid-template-columns:1fr 1fr; padding-top:5rem; }");
        out.println("    .hero-text { display:flex; flex-direction:column; justify-content:center; padding:5rem 4rem; }");
        out.println("    .hero-eyebrow { font-size:0.75rem; letter-spacing:0.35em; text-transform:uppercase; color:var(--caramel); margin-bottom:1.2rem; }");
        out.println("    .hero-headline { font-family:var(--display); font-size:clamp(3rem,5.5vw,5.5rem); font-weight:400; line-height:1.1; margin-bottom:1.5rem; }");
        out.println("    .hero-headline em { font-style:italic; color:var(--rose); }");
        out.println("    .hero-sub { font-size:1rem; color:#7a5c5a; max-width:36ch; margin-bottom:2.8rem; line-height:1.9; }");
        out.println("    .btn { display:inline-block; padding:0.9rem 2.4rem; text-decoration:none; font-size:0.8rem; letter-spacing:0.15em; text-transform:uppercase; transition:all 0.25s; border-radius:2px; margin-right:1rem; }");
        out.println("    .btn-fill { background:var(--rose); color:#fff; border:1px solid var(--rose); }");
        out.println("    .btn-fill:hover { background:var(--mocha); border-color:var(--mocha); }");
        out.println("    .btn-outline { border:1px solid var(--mocha); color:var(--mocha); }");
        out.println("    .btn-outline:hover { background:var(--mocha); color:#fff; }");

        // HERO VISUAL
        out.println("    .hero-visual { background:var(--blush); display:flex; flex-direction:column; align-items:center; justify-content:center; position:relative; overflow:hidden; }");
        out.println("    .cake-display { font-size:9rem; filter:drop-shadow(0 20px 40px rgba(212,112,138,0.25)); animation:float 4s ease-in-out infinite; }");
        out.println("    @keyframes float { 0%,100%{transform:translateY(0)} 50%{transform:translateY(-18px)} }");
        out.println("    .hero-badge { position:absolute; bottom:2.5rem; right:2.5rem; background:#fff; padding:1.2rem 1.6rem; border-radius:4px; text-align:center; box-shadow:0 8px 30px rgba(74,44,42,0.1); }");
        out.println("    .hero-badge strong { display:block; font-family:var(--display); font-size:1.6rem; color:var(--rose); }");
        out.println("    .hero-badge span { font-size:0.7rem; letter-spacing:0.15em; text-transform:uppercase; color:#b0908e; }");
        out.println("    .hero-tag { position:absolute; top:2.5rem; left:2.5rem; background:var(--caramel); color:#fff; padding:0.4rem 1rem; font-size:0.7rem; letter-spacing:0.2em; text-transform:uppercase; border-radius:2px; }");

        // MARQUEE
        out.println("    .marquee-wrap { overflow:hidden; background:var(--mocha); padding:0.85rem 0; }");
        out.println("    .marquee { display:flex; gap:2.5rem; animation:scroll 25s linear infinite; white-space:nowrap; }");
        out.println("    .marquee span { font-size:0.72rem; letter-spacing:0.25em; text-transform:uppercase; color:rgba(255,255,255,0.55); flex-shrink:0; }");
        out.println("    .marquee .dot { color:var(--rose); font-size:1rem; line-height:1; }");
        out.println("    @keyframes scroll { from{transform:translateX(0)} to{transform:translateX(-50%)} }");

        // SECTIONS
        out.println("    .section { padding:6rem 3rem; }");
        out.println("    .section-label { font-size:0.72rem; letter-spacing:0.35em; text-transform:uppercase; color:var(--caramel); margin-bottom:0.6rem; }");
        out.println("    .section-title { font-family:var(--display); font-size:clamp(2rem,3.5vw,3rem); font-weight:400; margin-bottom:0.5rem; }");
        out.println("    .section-sub { color:#7a5c5a; font-size:0.95rem; margin-bottom:3rem; }");

        // CAKE GRID
        out.println("    .cake-grid { display:grid; grid-template-columns:repeat(auto-fill,minmax(250px,1fr)); gap:2rem; }");
        out.println("    .cake-card { background:#fff; border-radius:6px; overflow:hidden; box-shadow:0 4px 20px rgba(74,44,42,0.06); transition:transform 0.3s, box-shadow 0.3s; cursor:pointer; }");
        out.println("    .cake-card:hover { transform:translateY(-6px); box-shadow:0 16px 40px rgba(74,44,42,0.14); }");
        out.println("    .cake-card:hover .cake-emoji { transform:scale(1.12) rotate(-4deg); }");
        out.println("    .cake-img { height:200px; display:flex; align-items:center; justify-content:center; font-size:5.5rem; transition:transform 0.4s; }");
        out.println("    .cake-body { padding:1.4rem; }");
        out.println("    .cake-name { font-family:var(--display); font-size:1.15rem; margin-bottom:0.3rem; }");
        out.println("    .cake-desc { font-size:0.82rem; color:#9a7a78; line-height:1.6; margin-bottom:1rem; }");
        out.println("    .cake-footer { display:flex; align-items:center; justify-content:space-between; }");
        out.println("    .cake-price { font-family:var(--display); font-size:1.2rem; color:var(--rose); }");
        out.println("    .cake-tag { font-size:0.65rem; letter-spacing:0.12em; text-transform:uppercase; background:var(--blush); color:var(--rose); padding:0.25rem 0.7rem; border-radius:20px; }");

        // WHY US
        out.println("    .why-section { background:var(--blush); }");
        out.println("    .why-grid { display:grid; grid-template-columns:repeat(3,1fr); gap:2rem; }");
        out.println("    .why-card { text-align:center; padding:2.5rem 1.5rem; }");
        out.println("    .why-icon { font-size:2.8rem; margin-bottom:1rem; display:block; }");
        out.println("    .why-title { font-family:var(--display); font-size:1.2rem; margin-bottom:0.5rem; }");
        out.println("    .why-text { font-size:0.88rem; color:#7a5c5a; line-height:1.7; }");

        // BANNER
        out.println("    .banner { background:var(--mocha); color:#fff; display:grid; grid-template-columns:1fr 1fr; min-height:380px; }");
        out.println("    .banner-text { padding:5rem 4rem; display:flex; flex-direction:column; justify-content:center; }");
        out.println("    .banner-text .section-label { color:var(--caramel); }");
        out.println("    .banner-text .section-title { color:#fff; margin-bottom:1rem; }");
        out.println("    .banner-text p { color:rgba(255,255,255,0.65); font-size:0.95rem; margin-bottom:2rem; max-width:36ch; }");
        out.println("    .banner-visual { display:flex; align-items:center; justify-content:center; font-size:9rem; opacity:0.2; }");

        // TESTIMONIALS
        out.println("    .testi-grid { display:grid; grid-template-columns:repeat(3,1fr); gap:1.5rem; }");
        out.println("    .testi-card { background:#fff; border-radius:6px; padding:2rem; box-shadow:0 4px 20px rgba(74,44,42,0.06); }");
        out.println("    .testi-stars { color:var(--caramel); font-size:1rem; margin-bottom:0.8rem; letter-spacing:0.1em; }");
        out.println("    .testi-text { font-size:0.9rem; color:#7a5c5a; line-height:1.8; margin-bottom:1.2rem; font-style:italic; }");
        out.println("    .testi-author { font-size:0.78rem; letter-spacing:0.1em; text-transform:uppercase; color:var(--mocha); font-style:normal; }");

        // NEWSLETTER
        out.println("    .newsletter { text-align:center; padding:6rem 3rem; border-top:1px solid var(--mist); }");
        out.println("    .newsletter .section-title { margin-bottom:0.6rem; }");
        out.println("    .newsletter p { color:#9a7a78; font-size:0.92rem; margin-bottom:2rem; }");
        out.println("    .email-form { display:flex; gap:0; max-width:440px; margin:0 auto; border-radius:3px; overflow:hidden; box-shadow:0 4px 20px rgba(74,44,42,0.1); }");
        out.println("    .email-form input { flex:1; padding:0.95rem 1.2rem; border:none; font-family:var(--body); font-size:0.88rem; outline:none; background:#fff; color:var(--mocha); }");
        out.println("    .email-form button { padding:0.95rem 1.8rem; background:var(--rose); color:#fff; border:none; cursor:pointer; font-family:var(--body); font-size:0.78rem; letter-spacing:0.15em; text-transform:uppercase; transition:background 0.2s; }");
        out.println("    .email-form button:hover { background:var(--mocha); }");

        // FOOTER
        out.println("    footer { background:var(--mocha); color:rgba(255,255,255,0.45); padding:3rem; text-align:center; font-size:0.8rem; }");
        out.println("    footer .footer-logo { font-family:var(--display); font-size:1.8rem; color:#fff; display:block; margin-bottom:0.8rem; font-style:italic; }");
        out.println("    footer a { color:var(--rose); text-decoration:none; }");

        // RESPONSIVE
        out.println("    @media(max-width:768px) {");
        out.println("      nav { padding:1.2rem 1.5rem; } .nav-links { display:none; }");
        out.println("      .hero { grid-template-columns:1fr; } .hero-visual { min-height:45vh; } .hero-text { padding:3rem 1.5rem; }");
        out.println("      .section { padding:4rem 1.5rem; }");
        out.println("      .why-grid, .testi-grid { grid-template-columns:1fr; }");
        out.println("      .banner { grid-template-columns:1fr; } .banner-visual { display:none; }");
        out.println("    }");
        out.println("  </style>");
        out.println("</head><body>");

        // ── NAV ──
        out.println("<nav>");
        out.println("  <a class='nav-logo' href='/cake_app_java/'>Crumbs <span>&</span> Co.</a>");
        out.println("  <ul class='nav-links'>");
        out.println("    <li><a href='/cake_app_java/cakes'>Our Cakes</a></li>");
        out.println("    <li><a href='/cake_app_java/cakes?category=Custom'>Custom Orders</a></li>");
        out.println("    <li><a href='#why'>About</a></li>");
        out.println("    <li><a href='#newsletter'>Contact</a></li>");
        out.println("  </ul>");
        out.println("</nav>");

        // ── HERO ──
        out.println("<section class='hero'>");
        out.println("  <div class='hero-text'>");
        out.println("    <p class='hero-eyebrow'>Artisan Bakery · Est. 2018</p>");
        out.println("    <h1 class='hero-headline'>Every slice<br/>tells a <em>sweet</em><br/>story.</h1>");
        out.println("    <p class='hero-sub'>Hand-baked with seasonal ingredients, no shortcuts. Cakes for birthdays, weddings, and every ordinary Tuesday.</p>");
        out.println("    <div>");
        out.println("      <a href='/cake_app_java/cakes' class='btn btn-fill'>Order a Cake</a>");
        out.println("      <a href='#why' class='btn btn-outline'>Our Story</a>");
        out.println("    </div>");
        out.println("  </div>");
        out.println("  <div class='hero-visual'>");
        out.println("    <div class='hero-tag'>Freshly Baked Daily</div>");
        out.println("    <div class='cake-display cake-emoji'>🎂</div>");
        out.println("    <div class='hero-badge'><strong>4.9★</strong><span>2,000+ Happy Orders</span></div>");
        out.println("  </div>");
        out.println("</section>");

        // ── MARQUEE ──
        out.println("<div class='marquee-wrap'><div class='marquee'>");
        String[] tags = {"Chocolate Truffle","Red Velvet","Mango Mousse","Butterscotch","Black Forest","Custom Wedding Cakes","Cheesecakes","Tiramisu"};
        StringBuilder m = new StringBuilder();
        for (String t : tags) m.append("<span>").append(t).append("</span><span class='dot'>♥</span>");
        for (String t : tags) m.append("<span>").append(t).append("</span><span class='dot'>♥</span>");
        out.println(m);
        out.println("</div></div>");

        // ── FEATURED CAKES ──
        out.println("<section class='section' id='cakes'>");
        out.println("  <p class='section-label'>This Week's Picks</p>");
        out.println("  <h2 class='section-title'>Freshly Baked Favourites</h2>");
        out.println("  <p class='section-sub'>Made this morning. Gone by evening.</p>");
        out.println("  <div class='cake-grid'>");

        String[][] cakes = {
            {"Chocolate Truffle",  "Rich dark chocolate ganache layered between moist cocoa sponge.",        "🍫", "#f5e6e8", "₹1,299", "Bestseller"},
            {"Red Velvet Dream",   "Classic cream cheese frosting on our signature crimson sponge.",          "🎂", "#fce8ec", "₹1,199", "Fan Favourite"},
            {"Mango Mousse",       "Light mango cream with Alphonso pulp, no-bake summer perfection.",        "🥭", "#fff3e0", "₹1,099", "Seasonal"},
            {"Black Forest",       "Kirsch-soaked cherries, fresh cream and dark chocolate shavings.",        "🍒", "#f3e8f5", "₹1,249", "Classic"},
        };
        for (String[] c : cakes) {
            out.println("  <div class='cake-card'>");
            out.println("    <div class='cake-img' style='background:" + c[3] + "'><span class='cake-emoji'>" + c[2] + "</span></div>");
            out.println("    <div class='cake-body'>");
            out.println("      <div class='cake-name'>" + c[0] + "</div>");
            out.println("      <div class='cake-desc'>" + c[1] + "</div>");
            out.println("      <div class='cake-footer'>");
            out.println("        <span class='cake-price'>" + c[4] + "</span>");
            out.println("        <span class='cake-tag'>" + c[5] + "</span>");
            out.println("      </div>");
            out.println("    </div>");
            out.println("  </div>");
        }
        out.println("  </div>");
        out.println("  <div style='text-align:center; margin-top:3rem'>");
        out.println("    <a href='/cake_app_java/cakes' class='btn btn-fill'>View All Cakes</a>");
        out.println("  </div>");
        out.println("</section>");

        // ── WHY US ──
        out.println("<section class='section why-section' id='why'>");
        out.println("  <p class='section-label'>Why Choose Us</p>");
        out.println("  <h2 class='section-title'>Baked with love,<br/>delivered with care.</h2>");
        out.println("  <br/>");
        out.println("  <div class='why-grid'>");
        String[][] why = {
            {"🌾", "Real Ingredients Only",    "No artificial colours, preservatives, or shortcuts. Every cake starts with fresh butter, free-range eggs, and seasonal fruit."},
            {"🎨", "Custom Designs",            "Send us a photo, a theme, or just a feeling. Our decorators bring your vision to life, from minimalist to maximalist."},
            {"🚚", "Same-Day Delivery",         "Order before noon, receive by 7 PM. We deliver across the city in insulated boxes that keep every layer perfect."},
        };
        for (String[] w : why) {
            out.println("  <div class='why-card'>");
            out.println("    <span class='why-icon'>" + w[0] + "</span>");
            out.println("    <div class='why-title'>" + w[1] + "</div>");
            out.println("    <div class='why-text'>" + w[2] + "</div>");
            out.println("  </div>");
        }
        out.println("  </div>");
        out.println("</section>");

        // ── CUSTOM ORDERS BANNER ──
        out.println("<section class='banner'>");
        out.println("  <div class='banner-text'>");
        out.println("    <p class='section-label'>Custom Orders</p>");
        out.println("    <h2 class='section-title'>Your dream cake,<br/>exactly as imagined.</h2>");
        out.println("    <p>Wedding tiers, photo cakes, corporate gifting — we take custom orders 5 days in advance. Free consultation for orders above ₹3,000.</p>");
        out.println("    <a href='/cake_app_java/cakes?category=Custom' class='btn btn-fill'>Start Your Order</a>");
        out.println("  </div>");
        out.println("  <div class='banner-visual'>🎂</div>");
        out.println("</section>");

        // ── TESTIMONIALS ──
        out.println("<section class='section' id='reviews'>");
        out.println("  <p class='section-label'>Sweet Words</p>");
        out.println("  <h2 class='section-title'>What our customers say</h2>");
        out.println("  <p class='section-sub'>Over 2,000 five-star orders and counting.</p>");
        out.println("  <div class='testi-grid'>");
        String[][] testimonials = {
            {"★★★★★", "The Black Forest was absolutely stunning — three layers, perfectly moist, and the cherries were fresh. My family couldn't believe it was delivered.", "Priya M., Chennai"},
            {"★★★★★", "Ordered a custom engagement cake with 48 hours notice. The team pulled it off flawlessly. It looked exactly like the reference photo I sent.", "Arjun K., Bengaluru"},
            {"★★★★★", "Best Mango Mousse I've ever had. Light, fragrant, not overly sweet. Will be ordering every summer without fail.", "Sneha R., Mumbai"},
        };
        for (String[] t : testimonials) {
            out.println("  <div class='testi-card'>");
            out.println("    <div class='testi-stars'>" + t[0] + "</div>");
            out.println("    <p class='testi-text'>\"" + t[1] + "\"</p>");
            out.println("    <span class='testi-author'>— " + t[2] + "</span>");
            out.println("  </div>");
        }
        out.println("  </div>");
        out.println("</section>");

        // ── NEWSLETTER ──
        out.println("<section class='newsletter' id='newsletter'>");
        out.println("  <p class='section-label'>Stay Sweet</p>");
        out.println("  <h2 class='section-title'>New flavours, first.</h2>");
        out.println("  <p>Seasonal menus, flash discounts, and baking tips — straight to your inbox.</p>");
        out.println("  <div class='email-form'>");
        out.println("    <input type='email' placeholder='your@email.com'/>");
        out.println("    <button type='button'>Subscribe</button>");
        out.println("  </div>");
        out.println("</section>");

        // ── FOOTER ──
        out.println("<footer>");
        out.println("  <span class='footer-logo'>Crumbs &amp; Co.</span>");
        out.println("  &copy; 2025 Crumbs &amp; Co. Artisan Bakery &nbsp;|&nbsp; Deployed on <a href='#'>Apache Tomcat 9 · Docker</a>");
        out.println("</footer>");
        out.println("</body></html>");
    }
}
