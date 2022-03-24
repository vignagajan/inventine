ClassicEditor.create(document.querySelector(".editor"), {
    toolbar: {
        items: [
            "heading",
            "|",
            "bold",
            "italic",
            "link",
            "bulletedList",
            "numberedList",
            "|",
            "indent",
            "outdent",
            "|",
            "imageUpload",
            "blockQuote",
            "mediaEmbed",
            "undo",
            "redo",
        ],
    },
    language: "en",
    image: {
        toolbar: ["imageTextAlternative", "imageStyle:full", "imageStyle:side"],
    },
    licenseKey: "",
})
    .then((editor) => {
        window.editor = editor;
    })
    .catch(error => {
        Swal.fire({
            icon: 'error',
            title: 'Something went wrong with the description.',
            iconColor: "#0097e6",
            confirmButtonColor: "#0097e6",
        });
    });