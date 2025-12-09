# Path Copier

[![JetBrains Plugins](https://img.shields.io/jetbrains/plugin/v/com.github.xkelxmc.pathcopier)](https://plugins.jetbrains.com/plugin/com.github.xkelxmc.pathcopier)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](LICENSE)

IntelliJ IDEA plugin that adds two buttons to the status bar for quick path copying.

## Features

- **Copy Absolute Path** — copies the full file path to clipboard
- **Copy Relative Path** — copies the path relative to the Git repository root (or project root as fallback)

## Installation

### From JetBrains Marketplace

1. Go to `Settings → Plugins → Marketplace`
2. Search for "Path Copier"
3. Click `Install`

### Manual Installation

1. Download the latest release from [Releases](https://github.com/xkelxmc/path-copier/releases)
2. Go to `Settings → Plugins → ⚙️ → Install Plugin from Disk...`
3. Select the downloaded `.zip` file

### Build from Source

```bash
./gradlew buildPlugin
```

The plugin zip will be in `build/distributions/`.

## Usage

After installation, two icons appear in the status bar (bottom right):

| Icon | Action |
|------|--------|
| Copy icon | Copy absolute path |
| Module icon | Copy relative path |

Just click the icon — the path is copied to your clipboard instantly.

## Requirements

- IntelliJ IDEA 2024.1+ (or other JetBrains IDEs based on IntelliJ Platform 241+)
- Git plugin enabled (for relative path from repo root)

## License

[Apache License 2.0](LICENSE)
