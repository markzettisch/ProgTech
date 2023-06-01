## 1. Rendszer célja
A rendszer célja, olyan Java alkalmazás fejlesztése, mely képes foglalásokat rögzíteni, tárolni és kiírni egy adatbázisba, majd onnan kiolvasni adatot. A program egyszerű felülettel rendelkezik. A felhasználó képes foglalni könnyedén az év, hónap és nap megadásával. További adatként megadható az éjszakák és a szobaszáma. 

## 2. Projektterv
### 2.1 Feladat: 
- adatbázis létrehozása az adatok tárolásához
- megfelelő funkciók elkészítése a projekt megfelelő működésének érdekében
- felhasználói felület kialakítása
- tesztelés

### 2.2 Ütemterv:
|Funkció                  | Feladat                                | Prioritás | Becslés (nap) | Aktuális becslés (nap) | Eltelt idő (nap) | Becsült idő (nap) |
|-------------------------|----------------------------------------|-----------|---------------|------------------------|------------------|---------------------|
|Rendszerterv             |Megírás                                 |         1 |             1 |                      1 |                1 |                   1 |
|Adatbázis                  |Elkészítés                |         2 |             1 |                      1 |                1 |                   1 |
|Program                  |Login elkészítése                |         3 |             2 |                      8 |                8 |                   8 |
|Program                  |Főoldal elkészítése                |         3 |             2 |                      8 |                8 |                   8 |
|Program                  |Admin panel elkészítése                |         3 |             2 |                      8 |                8 |                   8 |
|Program                  |Alapfunkciók elkészítése                |         3 |             8 |                      8 |                8 |                   8 |
|Program                  |Felhasználói felület kialakítása	                |         3 |             5 |                      5 |                5 |                   5 |
|Program                  |Tesztelés                |         4 |             2 |                      2 |                2 |                   2 |

### 2.3 Mérföldkövek:
   * Dokumentációk
   * Programírás kezdete
   * Program alapvető funkcióinak befejezése
   * Fejlesztés befejezése


## 3. Folyamatok modellje
### 3.1 Üzleti Entitások:
  - **Bejelentkezés**
  - **Kijelentkezés**
  - **Regisztráció**
  - **Lista**


## 4. Követelmények
**Funkcionális követelmények**
  - **Bejelentkezés**
  - **Kijelentkezés**
  - **Regisztráció**
  - **Foglalás rögzítés**
  - **Foglalás listázása**

  **Nem funkcionális követelmények**

  **Törvényi előírások, szabványok:**
  - **GDPR-nek való megfelelés**

## 5. Funkcionális terv
**Rendszerszereplők:**
 - **Rendszergazda**
 - **Felhasználó**


## 6. Fizikai környezet
- **Az alkalmazás csak windows operációs rendszerre készült, MySQL adatbázissal lesz futtatva.**
  - **Windows 64 bites operációs rendszeren futtatható.**
  - **Fejlesztői eszközök:**
    - **IntelliJ IDEA**
    - **Netbeans**
    - **Notepad++**
    - **XAMPP**

## 7. Architekturális terv
A rendszer működéséhez szükség van egy adatbázis szerverre, ebben az esetben MySQL-re esett a választás. Java JFrame felel a reszponzív design-ért. A backend java alapú.

## 8. Adatbázis terv

### **Táblák**
- **table01:** Regisztrált felhasználók adatai (felhasználónév, jelszó, név, regisztrálás dátuma)
- **table02:** -

## 9. Implementációs terv
Java alkalmazás készítése a következő tervezési minták igénybevételével:
- **Command** 
- **Absztrakt Factory** 


## 10. Tesztterv
Alapvető funkciók tesztelése Unit teszteléssel.

## 11. Telepítési terv
Java 20 és JDK 20, illetve Java futtatókörnyezet telepítése szükséges a program futtatásához.

## 12. Karbantartási terv
A kliens felhasználók az alkalmazásban megadott elérhetőségeken jelenthetik az esetlegesen felmerülő problémákat, hibákat, melyek javításra kerülnek.