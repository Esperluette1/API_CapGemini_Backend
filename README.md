## Avant de lancer le back
Vérifier que les ports pour accéder à la base de données sont les bons ou innocuppés dans ce fichier : 
API_CapGemini_Backend-main\polytech\src\main\java\com\univtours\polytech\resources\application.yml

## Lancer le back
*(Se positionner au niveau de `polytech` dans l’arborescence)*

---
## 0 — Configuration des variables d’environnement (si nécessaire)
```powershell
> $env:JAVA_HOME="C:\Program Files\Java\jdk-22"
> $env:PATH="$env:JAVA_HOME\bin;$env:PATH"
```
---
## 1 — Démarrage du back-end
```powershell
> mvn clean install  // ajouter -DskipTests si les tests ne passent pas
> mvn spring-boot:run
```
