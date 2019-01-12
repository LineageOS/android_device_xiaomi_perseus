# Camera
PRODUCT_PROPERTY_OVERRIDES += \
    persist.camera.remosaic.trigeriso=250 \
    persist.camera.sat.fallback.dist=45 \
    persist.camera.sat.fallback.dist.d=5 \
    persist.camera.sat.fallback.luxindex=310 \
    persist.camera.sat.fallback.lux.d=50 \
    persist.camera.saf.stablecnt=3

# Display density
PRODUCT_PROPERTY_OVERRIDES += \
    ro.sf.lcd_density=440

# Display features
PRODUCT_PROPERTY_OVERRIDES += \
    ro.displayfeature.histogram.enable=false \
    ro.eyecare.brightness.threshold=7 \
    ro.eyecare.brightness.level=5 \
    ro.hist.brightness.threshold=7
