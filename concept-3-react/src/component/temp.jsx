<button
  _newProperty=""
  class="
    border
    opacity-[1px]
    w-[180px]
    flex
    items-center
    justify-center
    text-[white] text-[24px]
    h-[36px]
    cursor-pointer
    rounded-[12px]
    border-solid
    max-md:w-[343px] max-md:h-[36px]
    max-sm:w-full
    max-sm:h-[36px]
    max-sm:bg-[rgba(249,245,245,1)]
    max-sm:text-black
    max-sm:left-[88px]
    max-sm:top-[323px]
  "
  data-el="button-1"
>
  Click me!
</button>
<script>
  (() => {
    const state = {};

    let context = null;
    let nodesToDestroy = [];
    let pendingUpdate = false;

    function destroyAnyNodes() {
      // destroy current view template refs before rendering again
      nodesToDestroy.forEach((el) => el.remove());
      nodesToDestroy = [];
    }

    // Function to update data bindings and loops
    // call update() when you mutate state and need the updates to reflect
    // in the dom
    function update() {
      if (pendingUpdate === true) {
        return;
      }
      pendingUpdate = true;

      document.querySelectorAll("[data-el='button-1']").forEach((el) => {
        el.removeEventListener("click", onButton1Click);
        el.addEventListener("click", onButton1Click);

        el.setAttribute("openLinkInNewTab", false);
      });

      destroyAnyNodes();

      pendingUpdate = false;
    }

    // Event handler for 'click' event on button-1
    function onButton1Click(event) {}

    // Update with initial state on first load
    update();
  })();
</script>