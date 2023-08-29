const ContactUs = () => {
  return (
    <section id="contact-form">
      <h2>Contact </h2>
      <p>
        We're here to help! Feel free to send us your questions or feedback.
      </p>
      <form>
        <label htmlFor="name">Name:</label>
        <input type="text" id="name" name="name" required />

        <label htmlFor="email">Email:</label>
        <input type="email" id="email" name="email" required />

        <label htmlFor="message">Message:</label>
        <textarea id="message" name="message" rows="4" required />

        <button type="submit">Submit</button>
      </form>
    </section>
  );
};
export default ContactUs;
