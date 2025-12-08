# Path Copier

IntelliJ IDEA plugin that adds two buttons to the status bar for quick path copying.

## Features

- **Copy Absolute Path** - copies the full file path to clipboard
- **Copy Relative Path** - copies the path relative to the Git repository root (or project root as fallback)

## Installation

1. Build the plugin:
   ```bash
   ./gradlew buildPlugin
   ```

2. Install in IDE:
   - Go to `Settings → Plugins → ⚙️ → Install Plugin from Disk...`
   - Select `build/distributions/path-1.0.0.zip`

## Usage

After installation, two icons appear in the status bar (bottom right):
- Click the **copy icon** to copy the absolute path
- Click the **module icon** to copy the relative path

## Requirements

- IntelliJ IDEA 2024.1+ (build 241+)
- Git plugin enabled (for relative path from repo root)

## License

Apache License 2.0
