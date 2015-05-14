#/bin/bash

echo "Begin checking url: $URL"

curl -s -m 5 -o /dev/null $URL

if [ $? -ne 0 ]; then
  echo "failed, continue..."
else
  echo "success"
  exit 0
fi

echo "Check failed"
exit 1
