# selenium-webdriver-poc

The current version of Selenium (2.53.1) works properly with Firefox 45

## For downloading and installing Firefox 45

- Step 1: Download the version
 - wget https://ftp.mozilla.org/pub/firefox/releases/45.0/linux-x86_64/en-US/firefox-45.0.tar.bz2

- Step 2: Extract the tar package
 - tar -xjf firefox-45.0.tar.bz2

- Step 3: Move the Firefox 45 folder to opt
 - Remove the Older version of firefox if it's there
  - sudo rm -rf  /opt/firefox
 - sudo mv firefox /opt/firefox45

- Step 4: Create Symbolic link for New Firefox as default
 - sudo mv /usr/bin/firefox /usr/bin/firefoxold
 - sudo ln -s /opt/firefox45/firefox /usr/bin/firefox

- Step 5:Check the installed version by using the below command
 - firefox --version
