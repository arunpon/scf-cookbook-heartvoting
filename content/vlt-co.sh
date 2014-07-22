#!/bin/bash
vlt co --filter filter.xml --force http://localhost:4502/crx/-/jcr:root jcr_root
find . -name .vlt -delete
find . -name "*.dir" | xargs rm -r
