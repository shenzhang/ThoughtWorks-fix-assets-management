#/bin/bash

echo "Begin checking url: $URL"

COUNT=0

if [ -z "$TOTAL" ]; then
  TOTAL=10
fi

while [ $COUNT -lt $TOTAL ]; do
	curl -s -m 2 -o /dev/null $URL

	if [ $? -ne 0 ]; then
	  echo "failed, continue..."
	else
	  echo "success"
	  exit 0
	fi

	let COUNT=COUNT+1

	sleep 5
done

echo "Check failed"
exit 1
