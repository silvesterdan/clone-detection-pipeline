#!/usr/bin/env bash
# ──────────────────────────────────────────────────────────────────────────────
# bootstrap_env.sh
#
# 1. Ensures a Python virtual environment for WSL exists (in ./wsl-venv)
# 2. Installs or upgrades required packages from requirements.txt
# 3. Activates the venv for use in this shell
# ──────────────────────────────────────────────────────────────────────────────

set -euo pipefail

VENV_DIR="wsl-venv"

# ── STEP 1: Create virtualenv ────────────────────────────────────────────────
echo "🔧 [1/4] Checking for virtual environment..."

if [ ! -d "$VENV_DIR" ]; then
  echo "🛠️   Creating virtualenv in ./$VENV_DIR..."
  python3 -m venv "$VENV_DIR"
  echo "✅  Virtualenv created."
else
  echo "✅  Virtualenv already exists."
fi

# ── STEP 2: Activate virtualenv ──────────────────────────────────────────────
echo " [2/4] Activating virtual environment..."
# shellcheck source=/dev/null
source "$VENV_DIR/bin/activate"
echo "🐍 Using Python: $(which python)"

# ── STEP 3: Check if requirements are already installed ──────────────────────
echo "🔍 [3/4] Checking for installed dependencies..."

if ! pip show tensorflow &>/dev/null; then
  echo "📦 Installing requirements from requirements.txt..."
  echo "⏳ This may take a few minutes..."
  pip install --upgrade pip
  pip install -r requirements.txt
  echo "✅ Requirements installed."
else
  echo "✅ Requirements already satisfied (tensorflow found)."
fi

# ── STEP 4: Finish ───────────────────────────────────────────────────────────
echo "✅ [4/4] Environment setup complete."
