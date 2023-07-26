<template>
    <form action="/userHome" class="search-bar" autocomplete="off">
        <div class="form-div">
            <input type="text" name="search" id="search" placeholder="Search...">
            <button type="submit" class="search-icon"><img src="../../assets/images/search.png" alt=""></button>
        </div>
        <ul class="list"></ul>
    </form>
</template>

<script>

export default{
    name: 'SearchBarComponent',
    mounted() {
        this.getNames();
        this.hideList();

        try {
            document.querySelector(".search-bar").addEventListener("focusout", () => {
                setTimeout(() => {
                    this.hideList()
                }, 500);
            });
            document.querySelector(".search-bar").addEventListener("focusin", () => this.showList());
        }
        catch {
            return;
        }
    },
    data() {
        return {
            input: ''
        }
    },
    methods: {
        searchBarShow() {
            document.getElementById("outside-button").style.display = "none";
            document.getElementById("search-bar-small").style.display = "flex";
        },
        getNames() {
            window.$.getJSON('/companies.json', (companies) => {
                var names = [];
                Object.keys(companies).forEach(name => {
                    names.push(name);
                });
                
                const sortedNames = names.sort();

                this.input = document.querySelector("#userHome input");
                
                try{
                    this.input.addEventListener("keyup", () => {

                        if(this.input.value == "") this.hideList();
                        else this.showList();

                        this.removeElements();

                        var found = false;

                        for (let i of sortedNames) {

                            if(i.toLowerCase().startsWith(this.input.value.toLowerCase()) && this.input.value != "") {
                                let listItem = document.createElement("li");

                                listItem.classList.add("list-items");
                                listItem.style.cursor = "pointer";
                                listItem.addEventListener("click", () => {
                                    this.input.value = i
                                    this.removeElements();
                                    this.hideList();
                                });

                                let word = "<b>" + i.substr(0, this.input.value.length) + "</b>"
                                word += i.substr(this.input.value.length);
                                
                                listItem.innerHTML = word;
                                document.querySelector(".list").appendChild(listItem);

                                found = true;
                            }
                        }
                        if(!found) {
                            let listItem = document.createElement("li");

                            listItem.classList.add("list-items");

                            let word = "<b>No matches found</b>";
                            listItem.innerHTML = word;
                            document.querySelector(".list").appendChild(listItem);
                        }
                    })
                }
                catch{
                    return;
                }
            });
        },
        removeElements() {
            let items = document.querySelectorAll(".list-items");
            items.forEach((item) => {
                item.remove();
            });
        },
        hideList() {
            let list = document.querySelector(".list");
            if(list.classList.length == 1) {
                list.classList.add("hide-list")
            }
        },
        showList() {
            let list = document.querySelector(".list");
            if(list.classList.length == 2 && document.querySelector("#userHome input").value != "") {
                list.classList.remove("hide-list")
            }
        }
    }
}

</script>

<style>
@import '../../assets/css/mainPageCSS/searchbarComponent.css';
</style>