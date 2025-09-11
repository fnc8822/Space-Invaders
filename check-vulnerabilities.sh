#!/bin/bash

echo "=== Running Horusec Scan ==="

# Run Horusec and capture all output (stdout and stderr)
HORUSEC_OUTPUT=$(docker run --rm -v $(pwd):/src horuszup/horusec-cli:v2.9.0-beta.3 \
horusec start -p /src --disable-docker --enable-owasp-dependency-check --log-level=info --information-severity 2>&1)

echo "$HORUSEC_OUTPUT"

echo -e "\n=== Counting Vulnerabilities from Console Output ==="

# Count vulnerabilities from the actual console output (fixed syntax)
CRITICAL_COUNT=$(echo "$HORUSEC_OUTPUT" | grep -c "Severity: CRITICAL")
HIGH_COUNT=$(echo "$HORUSEC_OUTPUT" | grep -c "Severity: HIGH")
MEDIUM_COUNT=$(echo "$HORUSEC_OUTPUT" | grep -c "Severity: MEDIUM")
LOW_COUNT=$(echo "$HORUSEC_OUTPUT" | grep -c "Severity: LOW")
INFO_COUNT=$(echo "$HORUSEC_OUTPUT" | grep -c "Severity: INFO")

# Ensure counts are integers (grep -c returns 0 if no matches found)
CRITICAL_COUNT=${CRITICAL_COUNT:-0}
HIGH_COUNT=${HIGH_COUNT:-0}
MEDIUM_COUNT=${MEDIUM_COUNT:-0}
LOW_COUNT=${LOW_COUNT:-0}
INFO_COUNT=${INFO_COUNT:-0}

echo "=== Vulnerability Summary ==="
echo "- CRITICAL: $CRITICAL_COUNT"
echo "- HIGH: $HIGH_COUNT"
echo "- MEDIUM: $MEDIUM_COUNT"  
echo "- LOW: $LOW_COUNT"
echo "- INFO: $INFO_COUNT"

# Your custom thresholds
MAX_CRITICAL=0
MAX_HIGH=3

# Check thresholds
FAILED=false

if [ "$CRITICAL_COUNT" -gt "$MAX_CRITICAL" ]; then
    echo "❌ CRITICAL vulnerabilities ($CRITICAL_COUNT) exceed threshold ($MAX_CRITICAL)"
    FAILED=true
fi

if [ "$HIGH_COUNT" -gt "$MAX_HIGH" ]; then
    echo "❌ HIGH vulnerabilities ($HIGH_COUNT) exceed threshold ($MAX_HIGH)"
    FAILED=true
fi

if [ "$FAILED" = true ]; then
    echo "=== PIPELINE BLOCKED - Vulnerability thresholds exceeded ==="
    exit 1
fi

echo "✅ Vulnerability counts within acceptable thresholds"#!/bin/bash

echo "=== Running Horusec Scan ==="

# Run Horusec and capture all output (stdout and stderr)
HORUSEC_OUTPUT=$(docker run --rm -v $(pwd):/src horuszup/horusec-cli:v2.9.0-beta.3 \
horusec start -p /src --disable-docker --enable-owasp-dependency-check --log-level=info --information-severity 2>&1)

echo "$HORUSEC_OUTPUT"

echo -e "\n=== Counting Vulnerabilities from Console Output ==="

# Count vulnerabilities from the actual console output
CRITICAL_COUNT=$(echo "$HORUSEC_OUTPUT" | grep -c "Severity: CRITICAL" || echo 0)
HIGH_COUNT=$(echo "$HORUSEC_OUTPUT" | grep -c "Severity: HIGH" || echo 0)
MEDIUM_COUNT=$(echo "$HORUSEC_OUTPUT" | grep -c "Severity: MEDIUM" || echo 0)
LOW_COUNT=$(echo "$HORUSEC_OUTPUT" | grep -c "Severity: LOW" || echo 0)
INFO_COUNT=$(echo "$HORUSEC_OUTPUT" | grep -c "Severity: INFO" || echo 0)

echo "=== Vulnerability Summary ==="
echo "- CRITICAL: $CRITICAL_COUNT"
echo "- HIGH: $HIGH_COUNT"
echo "- MEDIUM: $MEDIUM_COUNT"  
echo "- LOW: $LOW_COUNT"
echo "- INFO: $INFO_COUNT"

# Your custom thresholds
MAX_CRITICAL=0
MAX_HIGH=3

# Check thresholds
FAILED=false

if [ "$CRITICAL_COUNT" -gt "$MAX_CRITICAL" ]; then
    echo "❌ CRITICAL vulnerabilities ($CRITICAL_COUNT) exceed threshold ($MAX_CRITICAL)"
    FAILED=true
fi

if [ "$HIGH_COUNT" -gt "$MAX_HIGH" ]; then
    echo "❌ HIGH vulnerabilities ($HIGH_COUNT) exceed threshold ($MAX_HIGH)"
    FAILED=true
fi

if [ "$FAILED" = true ]; then
    echo "=== PIPELINE BLOCKED - Vulnerability thresholds exceeded ==="
    exit 1
fi

echo "✅ Vulnerability counts within acceptable thresholds"