<template>
    <div id="first-section">
        <div class="intro">
            <h1>A solution for Investors, Analysts and Industry Leaders</h1>
            <div class="start-here">
                <router-link to="/login"><button type="button">Start Here</button></router-link>
                <button type="button" onclick="location.href='/login'" class="button-arrow"><img
                        src="../../assets/images/arrow.png" alt=""></button>
            </div>
        </div>
    </div>

    <div id="firstToSecond">
        <svg id="visual" viewBox="0 0 900 200" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
            version="1.1">
            <path id="wave1"
                d="M0 165L21.5 158.2C43 151.3 86 137.7 128.8 134.3C171.7 131 214.3 138 257.2 145.3C300 152.7 343 160.3 385.8 163C428.7 165.7 471.3 163.3 514.2 157.7C557 152 600 143 642.8 141.8C685.7 140.7 728.3 147.3 771.2 153.3C814 159.3 857 164.7 878.5 167.3L900 170L900 201L878.5 201C857 201 814 201 771.2 201C728.3 201 685.7 201 642.8 201C600 201 557 201 514.2 201C471.3 201 428.7 201 385.8 201C343 201 300 201 257.2 201C214.3 201 171.7 201 128.8 201C86 201 43 201 21.5 201L0 201Z"
                fill="#9DCBDC" stroke-linecap="round" stroke-linejoin="miter">
            </path>
            <path id="wave2"
                d="M0 165L21.5 160C43 155 86 145 128.8 145.8C171.7 146.7 214.3 158.3 257.2 160.3C300 162.3 343 154.7 385.8 147.7C428.7 140.7 471.3 134.3 514.2 132.7C557 131 600 134 642.8 134.8C685.7 135.7 728.3 134.3 771.2 140.3C814 146.3 857 159.7 878.5 166.3L900 173L900 201L878.5 201C857 201 814 201 771.2 201C728.3 201 685.7 201 642.8 201C600 201 557 201 514.2 201C471.3 201 428.7 201 385.8 201C343 201 300 201 257.2 201C214.3 201 171.7 201 128.8 201C86 201 43 201 21.5 201L0 201Z"
                fill="#9DCBDC" stroke-linecap="round" stroke-linejoin="miter">
            </path>
        </svg>
    </div>
</template>


<script async>
export default {
    name: 'HomeComponent',
    mounted() {
        window.addEventListener('resize', this.adaptSpacer);
        this.positionSpacer();

        const script = document.createElement('script');
        script.src = 'https://cdn.jsdelivr.net/npm/kute.js@2.2.4/dist/kute.min.js';
        script.async = true;
        script.onload = () => {
            this.initializeAnimation();
        };
        document.head.appendChild(script);
    },
    methods: {
        adaptSpacer() {
            var elementHeight;
            try {
                elementHeight = document.getElementById('visual').clientHeight;
            } catch {
                elementHeight = 0;
            }
            var topOffset = elementHeight;
            try {
                document.getElementById('firstToSecond').style.bottom = topOffset.toString() + "px"
            }
            catch {
                return
            }
            
        },
        positionSpacer() {
            var elementHeight;
            try {
                elementHeight = document.getElementById('visual').clientHeight;
            } catch {
                elementHeight = 0;
            }
            var topOffset = elementHeight - 45;
            document.getElementById('firstToSecond').style.bottom = topOffset.toString() + "px"
        },
        initializeAnimation() {
            const tween = window.KUTE.fromTo(
                '#wave1',
                { path: '#wave1' },
                { path: '#wave2' },
                { repeat: 999, duration: 4000, yoyo: true }
            )
            tween.start()
        }
    }
}
</script>

<style>@import "@/assets/css/mainPageCSS/homeComponent.css";</style>