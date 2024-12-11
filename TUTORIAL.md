## Tutorial: Adding Static Code Analysis with Detekt and Pre-Commit Hook to an Android Project
**Introduction**

This tutorial will guide you through adding Detekt (a static code analysis tool for Kotlin) to your Android project and configuring a pre-commit hook to automatically run Detekt before each commit. This ensures your code adheres to best practices and is maintainable.
Prerequisites

    Gradle: Ensure you have Gradle installed and properly set up in your Android project.
    Pre-commit: Install the pre-commit package to manage hooks for your project.

## **Step 1: Install Detekt**

    Open your project: Navigate to the root directory of your Android project.

    Add Detekt Plugin: In your project’s build.gradle.kts file, apply the Detekt plugin. Add the following lines to the plugins block:

plugins {
    id("io.gitlab.arturbosch.detekt").version("1.23.0")  // Add this line
}

Configure Detekt: Create a new file named detekt.yml in your project’s root directory to configure Detekt. You can either create this file manually or use the default configuration provided by Detekt.

## Example configuration:

detekt:
  config: detekt.yml
  parallel: true
  build: true

# Rules
formatting:
  active: true
complexity:
  active: true

## Add Detekt dependencies: In the dependencies section of your build.gradle.kts, add:

dependencies {
    detektPlugins "io.gitlab.arturbosch.detekt:detekt-formatting:1.23.0"
}

Run Detekt: You can run Detekt manually using the command:

    ./gradlew detekt

    This will analyze your project and display the results in the terminal.

**Step 2: Set Up Pre-commit Hook**

## To ensure Detekt runs before every commit, we’ll configure a pre-commit hook.
1. Install Pre-commit

First, ensure that pre-commit is installed on your machine. Run the following command:

pip install pre-commit

2. Create .pre-commit-config.yaml

## In the root of your project, create a file named .pre-commit-config.yaml with the following content to add a hook for running Detekt:

- repo: https://github.com/pre-commit/mirrors-gradle
  rev: v7.4.0
  hooks:
    - id: gradle-detect
      name: Run Detekt
      files: \.kt$  # Ensure it only runs for Kotlin files

3. ## Install the Hook

After creating the .pre-commit-config.yaml file, run the following command to install the pre-commit hook:

pre-commit install

This command will install the hook defined in .pre-commit-config.yaml and configure it to run Detekt on Kotlin files.
Step 3: Use Detekt with Pre-commit Hook

Now that the pre-commit hook is set up, Detekt will run automatically every time you try to commit changes. To test it:

    Make some changes to your Kotlin files.

    Attempt to commit these changes:

    git commit -m "Your commit message"

    If Detekt finds any issues, it will prevent the commit and display the warnings in the terminal.

## Step 4: (Optional) Customize Detekt Rules

You can customize the Detekt rules based on your team's coding standards by modifying the detekt.yml file. For instance, you can disable certain rules, adjust the severity of issues, or enable specific rules for different code styles.
Troubleshooting

    Detekt not running:
        Ensure that the Detekt plugin is correctly added to build.gradle.kts.
        Make sure that pre-commit is installed and configured correctly.
    Pre-commit hook not working:
        Verify that you have installed the pre-commit hooks using pre-commit install.
        Check the .pre-commit-config.yaml file for any misconfigurations.