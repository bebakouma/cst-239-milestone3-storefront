# CST-239 Milestone 3 – StoreFront Application  
**Batossa Bakouma – May 2025**

---

## 📺 Screencast Video  
▶ [Watch on Loom](https://www.loom.com/share/64555883e5de4822a8aecca73db763f6)

## 📁 GitHub Repository  
🔗 [https://github.com/bebakouma/cst-239-milestone3-storefront](https://github.com/bebakouma/cst-239-milestone3-storefront)

---

## 🛍️ Description  
This Java console application simulates a StoreFront system with inventory and shopping cart functionality.

### Features:
- View products (`InventoryManager`)
- Buy products (decreases inventory, adds to cart)
- Cancel purchases (restocks inventory, removes from cart)
- View & empty cart (`ShoppingCart`)
- Exit system gracefully

---

## ▶ How to Run

### PowerShell:
```powershell
javac -d out (Get-ChildItem -Recurse -Filter *.java -File -Path .\src\main\java\ | ForEach-Object { $_.FullName })
java -cp out edu.gcu.storefront.StoreFrontApplication
