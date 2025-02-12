# MatchN - Java Card Game

MatchN is a turn-based card game where players pass and discard cards to form **N** matches in their hand. The game continues until a player reaches **N** matches or the deck is exhausted.

## 🃏 How to Play
1. At the start, the player **chooses**:
   - The **number of players**.
   - The **number of cards needed for a match**.
   - The **number of cards to discard per turn**.
2. The first player **draws** a card from the deck.
3. They **choose which card(s) to pass** to the next player.
4. The next player repeats this until the last player, who **discards into a pile**.
5. The game continues until a player achieves **N matches**.
6. If the deck runs out, the **discard pile is shuffled and reused**.
7. The first player to get **N matching cards** wins!

## 🔧 Technologies Used
- **Java** for game logic
- **Java Collections Framework** for managing cards and game mechanics

## 🚀 Installation & Running the Game
1. **Clone the repository:**
   ```sh
   git clone https://github.com/houdaslaoui/MatchN
   cd MatchN
2. **Compile the game:**
   javac MatchN.java
3. **Run the game:**
   java MatchN 
