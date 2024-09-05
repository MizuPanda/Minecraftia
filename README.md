# Minecraftia RPG Stats Mod

![Mod Version](https://img.shields.io/badge/version-0.0.1-blue.svg)
![Neoforge](https://img.shields.io/badge/neoforge-1.21-brightgreen.svg)
![Minecraft Version](https://img.shields.io/badge/minecraft-1.21-brightgreen.svg)
![In Development](https://img.shields.io/badge/status-in%20development-yellow)

## Description

**Minecraftia RPG Stats Mod** is a custom role-playing game (RPG) stats system mod for Minecraft, built using Neoforge 1.21. It introduces various character statistics, leveling systems, and other RPG-like elements to enhance the player’s in-game progression. 

Key features include:
- Customizable stats system (e.g., Strength, Agility, Defense)
- Experience and leveling mechanics
- Integration with existing Minecraft systems
- Custom events and effects for stat management

## Requirements

- **Minecraft Version**: 1.21+
- **Neoforge**: 1.21 (or later)
- **Java**: 17+
- **Other Dependencies**:
    - [Neoforge Mod Loader](https://neoforged.net/)

## Installation

1. Download and install **Minecraft 1.21**.
2. Install the latest version of **Neoforge** mod loader for Minecraft.
3. Download the `minecraftia-rpg-stats-mod.jar` from the [releases page](https://github.com/MizuPanda/Minecraftia/releases)
4. Place the `.jar` file in your Minecraft `mods` folder, located in `AppData/Roaming/.minecraft/mods/`.
5. Launch Minecraft with the Neoforge profile to activate the mod.

## Features

- **Custom Stats**: Players can develop unique stats such as Strength, Agility, Endurance, and more, each influencing gameplay.
- **Experience System**: Earn XP by completing tasks, killing mobs, or mining, and level up to gain bonuses.
- **API for Modders**: Expose custom stats to other mods for integration or enhancement.
- **Configurable via JSON**: Modify the stats, XP rates, and leveling curves through an easy-to-edit JSON configuration file.

## Usage

### Viewing Stats
To check your character stats in-game, press V.

This key opens a UI showing current stats like Strength, Agility, and more.

### Managing Stats
Admins or users with permission can manually adjust stats:

/minecraftia stats set <stat_name> <value\>

### Customizing Stats
You can customize the stats available and the XP required for leveling in the `config/minecraftia/stats.json` file. Example:

```json
{
  "stats": {
    "strength": {
      "xp_per_hit": 0.01
    },
    "agility": {
      "xp_per_jump": 0.001
    }
  }
}
```

### Development Setup
To set up the development environment for Minecraftia RPG Stats Mod:

1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/minecraftia-rpg-stats-mod.git
    cd minecraftia-rpg-stats-mod
    ```
2. Install dependencies and build the project:
    ```bash
    ./gradlew build
    ```
3. Open the project in your preferred IDE (e.g., IntelliJ IDEA).
4. Run the mod in the development environment:
    ```bash
    ./gradlew runClient
    ```
### Contributing
We welcome contributions! To contribute:

1. Fork the repository.
2. Create a new feature branch (`git checkout -b feature/new-feature`).
3. Commit your changes (`git commit -m 'Add new feature'`).
4. Push the branch (`git push origin feature/new-feature`).
5. Create a Pull Request.

Please make sure to test your changes before submitting.

### Issues
If you encounter any issues or bugs, feel free to open an issue on our GitHub Issues page.
