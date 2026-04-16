<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Amazon Clone | Welcome</title>
    <style>
        :root {
		    --amazon-navy: #232f3e;
		    --amazon-orange: #ff9900;
		    --light-gray: #f3f3f3;
		}		

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: var(--light-gray);
            margin: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        .header {
		    background-color: var(--amazon-navy);
		    color: white;
		    width: 100%;
		    padding: 20px 0;
		    text-align: center;
		    position: fixed;
		    top: 0;
		    box-shadow: 0 2px 5px rgba(0,0,0,0.2);
		}

        .container {
            margin-top: 80px;
            text-align: center;
        }

        .portal-wrapper {
            display: flex;
            gap: 30px;
            margin-top: 40px;
        }

        .card {
		    background: white;
		    padding: 40px;
		    border-radius: 8px;
		    box-shadow: 0 4px 15px rgba(0,0,0,0.1);
		    width: 250px;
		    text-decoration: none;
		    color: #333;
		    transition: box-shadow 0.25s ease, border-bottom 0.25s ease;
		    border-bottom: 4px solid transparent;
		}

        .card:hover {
			    box-shadow: 0 6px 18px rgba(0,0,0,0.18);
			    border-bottom: 4px solid var(--amazon-orange);
			}

        .card h3 {
            margin-top: 0;
            color: var(--amazon-navy);
        }

        .btn {
		    display: inline-block;
		    margin-top: 20px;
		    padding: 10px 20px;
		    background-color: var(--amazon-orange);
		    color: var(--amazon-navy);
		    font-weight: bold;
		    border-radius: 5px;
		    text-decoration: none;
		}

        
    </style>
</head>
<body>

    <div class="header">
        <h2>Amazon Ecommerce Platform</h2>
    </div>

    <div class="container">
        <h1>Select Your Portal</h1>
        <div class="portal-wrapper">
            
            <a href="reseller" class="card">
                <h3 class="reseller-icon">Reseller</h3>
                <p>Manage products, update prices, and track inventory stock.</p>
                <div class="btn">Admin Dashboard</div>
            </a>

            <a href="customer" class="card">
                <h3 class="user-icon">Customer</h3>
                <p>Search for items, view prices, and place your orders.</p>
                <div class="btn">Start Shopping</div>
            </a>

        </div>
    </div>

</body>
