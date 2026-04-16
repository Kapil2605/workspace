<%@ page import="java.util.List" %>
<%@ page import="com.ecommerce.dto.CartItemDTO" %>

<%
    List<CartItemDTO> cartItems = (List<CartItemDTO>) request.getAttribute("cartItems");
    double total = 0.0;
    int totalQuantity = 0;
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Amazon Ecommerce Shopping Cart</title>
    <link href="https://fonts.googleapis.com/css2?family=Public+Sans:wght@400;600;700&display=swap" rel="stylesheet">
    
    <style>
        :root {
            --amazon-navy: #131921;
            --amazon-orange: #FF9900;
            --amazon-yellow: #FFD814;
            --amazon-yellow-hover: #F7CA00;
            --link-blue: #007185;
            --price-red: #B12704;
            --border-color: #DDD;
            --bg-gray: #EAEDED;
        }

        body {
            font-family: 'Public Sans', Arial, sans-serif;
            background-color: var(--bg-gray);
            margin: 0;
            color: #0F1111;
        }

        /* Header Styling */
        .header {
            background-color: var(--amazon-navy);
            color: white;
            padding: 10px 20px;
            display: flex;
            align-items: center;
        }

        .header h1 {
            font-size: 20px;
            margin: 0;
            display: flex;
            align-items: center;
            gap: 10px;
        }

        /* Layout Container */
        .main-wrapper {
            max-width: 1500px;
            margin: 0 auto;
            display: flex;
            padding: 20px;
            gap: 20px;
        }

        /* Left Section: Cart Items */
        .cart-container {
            flex: 3;
            background: white;
            padding: 20px 25px;
        }

        .cart-header {
            border-bottom: 1px solid var(--border-color);
            padding-bottom: 10px;
            margin-bottom: 0;
        }

        .price-label-header {
            text-align: right;
            font-size: 14px;
            color: #565959;
            margin-bottom: 5px;
        }

        /* Cart Item Design */
        .cart-item {
            display: flex;
            padding: 20px 0;
            border-bottom: 1px solid var(--border-color);
        }

        .item-image {
            width: 180px;
            height: 180px;
            object-fit: contain;
            margin-right: 20px;
        }

        .item-details {
            flex-grow: 1;
        }

        .item-name {
            font-size: 18px;
            font-weight: 600;
            color: var(--link-blue);
            text-decoration: none;
            line-height: 1.3;
            margin-bottom: 4px;
            display: block;
        }

        .item-stock {
            color: #007600;
            font-size: 12px;
            margin: 5px 0;
        }

        .qty-row {
            display: flex;
            align-items: center;
            gap: 15px;
            margin-top: 15px;
        }

        /* Amazon Style Qty Selector */
        .qty-selector {
            display: flex;
            align-items: center;
            background: #F0F2F2;
            border: 1px solid #D5D9D9;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(213,217,217,.5);
        }

        .qty-btn {
            background: transparent;
            border: none;
            padding: 6px 12px;
            cursor: pointer;
            font-size: 18px;
            font-weight: bold;
        }

        .qty-count {
            padding: 0 10px;
            font-size: 14px;
            border-left: 1px solid #D5D9D9;
            border-right: 1px solid #D5D9D9;
        }

        .action-link {
            font-size: 12px;
            color: var(--link-blue);
            cursor: pointer;
            text-decoration: none;
        }

        .action-link:hover {
            text-decoration: underline;
            color: #C7511F;
        }

        .divider {
            color: var(--border-color);
            margin: 0 5px;
        }

        .item-price-col {
            text-align: right;
            min-width: 100px;
        }

        .item-price {
            font-size: 18px;
            font-weight: 700;
        }

        /* Right Section: Sidebar */
        .checkout-sidebar {
            flex: 1;
            background: white;
            padding: 20px;
            height: fit-content;
        }

        .subtotal-text {
            font-size: 18px;
            margin-bottom: 20px;
        }

        .checkout-btn {
            width: 100%;
            background-color: var(--amazon-yellow);
            border: 1px solid #FCD200;
            border-radius: 8px;
            padding: 10px;
            font-size: 14px;
            cursor: pointer;
            box-shadow: 0 2px 5px rgba(213,217,217,.5);
        }

        .checkout-btn:hover {
            background-color: var(--amazon-yellow-hover);
        }

        .empty-cart-msg {
            text-align: center;
            padding: 40px;
        }
    </style>

    <script>
        function updateQuantity(productName, action) {
            // In a real app, use productID instead of Name
            window.location.href = "updateQuantity?productName=" 
                + encodeURIComponent(productName) + "&action=" + action;
        }

        function removeItem(productName) {
            window.location.href = "removeItem?productName=" 
                + encodeURIComponent(productName);
        }
    </script>
</head>
<body>

<div class="header">
    <h1> Amazon Ecommerce</h1>
</div>

<div class="main-wrapper">
    <div class="cart-container">
        <h2 class="cart-header">Shopping Cart</h2>
        <div class="price-label-header">Price</div>

        <%
            if (cartItems != null && !cartItems.isEmpty()) {
                for (CartItemDTO item : cartItems) {
                    double itemTotal = item.getPrice() * item.getQuantity();
                    total += itemTotal;
                    totalQuantity += item.getQuantity();
        %>

        <div class="cart-item">
            <img src="https://images.unsplash.com/photo-1505740420928-5e560c06d30e?q=80&w=1000&auto=format&fit=crop" alt="Product" class="item-image">
            
            <div class="item-details">
                <a href="#" class="item-name"><%= item.getProductName() %></a>
                <div class="item-stock">In stock</div>
                <div class="qty-row">
                    <div class="qty-selector">
                        <button class="qty-btn" onclick="updateQuantity('<%= item.getProductName() %>', 'decrease')">-</button>
                        <span class="qty-count">Qty: <%= item.getQuantity() %></span>
                        <button class="qty-btn" onclick="updateQuantity('<%= item.getProductName() %>', 'increase')">+</button>
                    </div>
                    <span class="divider">|</span>
                    <span class="action-link" onclick="removeItem('<%= item.getProductName() %>')">Delete</span>
                    <span class="divider">|</span>
                    <span class="action-link">Save for later</span>
                </div>
            </div>

            <div class="item-price-col">
                <div class="item-price">Rs <%= String.format("%.2f", itemTotal) %></div>
            </div>
        </div>

        <%
                }
            } else {
        %>
            <div class="empty-cart-msg">
                <h3>Your Amazon Cart is empty.</h3>
                <p>Check your Saved for later items below or <a href="products">continue shopping</a>.</p>
            </div>
        <%
            }
        %>
        
        <div style="text-align: right; padding-top: 15px;">
            <span style="font-size: 18px;">Subtotal (<%= totalQuantity %> items): <b>Rs <%= String.format("%.2f", total) %></b></span>
        </div>
    </div>

    <div class="checkout-sidebar">
        <div class="subtotal-text">
            Subtotal (<%= totalQuantity %> items): <br>
            <strong>Rs <%= String.format("%.2f", total) %></strong>
        </div>
        <button class="checkout-btn">Proceed to Buy</button>
    </div>
</div>

</body>
</html>