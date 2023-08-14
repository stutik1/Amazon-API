//// Array to store cart items
//        let cartItems = [];
//
//        // Function to add an item to the cart
//        function addToCart() {
//            cartItems.push("Product Name");
//            updateCart();
//        }
//
//        // Function to update the cart display
//        function updateCart() {
//            const cartList = document.getElementById("cart-items");
//            cartList.innerHTML = "";
//            cartItems.forEach(item => {
//                const li = document.createElement("li");
//                li.textContent = item;
//                cartList.appendChild(li);
//            });
//        }
//
//        // Function to place an order
//        function placeOrder() {
//            if (cartItems.length > 0) {
//                const orderNumber = Math.floor(Math.random() * 1000000);
//                alert(`Order placed! Your order number is: ${orderNumber}`);
//                cartItems = [];
//                updateCart();
//            } else {
//                alert("Your cart is empty. Add items before placing an order.");
//            }
//        }
//
//        // Function to track an order
//        function trackOrder() {
//            const orderNumberInput = document.getElementById("order-number");
//            const orderNumber = parseInt(orderNumberInput.value);
//            const orderStatus = document.getElementById("order-status");
//
//            // Simulated order tracking logic
//            if (orderNumber) {
//                const randomStatus = Math.random() > 0.5 ? "Shipped" : "Processing";
//                orderStatus.textContent = `Order ${orderNumber} status: ${randomStatus}`;
//            } else {
//                orderStatus.textContent = "Please enter a valid order number.";
//            }
//        }