# Subnet Calculator

A simple **Java-based subnet calculator** for IPv4 networks.

You give it an IP address and subnet mask (or CIDR), and it calculates:

- Network address  
- Broadcast address  
- First and last usable host  
- Number of usable hosts  
- Subnet / prefix length (CIDR)  

This is mainly a **learning/project tool** for networking and Java, but it’s also handy as a quick CLI subnet helper.

---

## ✨ Features

- Accepts IPv4 address + subnet mask (or prefix length)
- Validates input format
- Calculates:
  - Network address
  - Broadcast address
  - First usable host
  - Last usable host
  - Total hosts / usable hosts
- Outputs everything in a clean, readable format
- Implemented in pure Java, no external dependencies

---

## 🛠 Tech Stack

- **Language:** Java  
- **Type:** Swing UI  

---

## 📁 Project Structure

```text
Subnet-Calculator/
├── build/
├── nbproject/
├── src/
│   └── ... (Java source files)
├── build.xml
└── manifest.mf
