import React, { Fragment } from "react";
import Header from "../components/Header/Header";
import HeroSection from "../components/Hero-Section/HeroSection";

import FreeCourse from "../components/Free-course-section/FreeCourse";


import Footer from "../components/Footer/Footer";

const Home = () => {
  return (
    <Fragment>
      <Header />
      <HeroSection />
      <FreeCourse />
      <Footer />
    </Fragment>
  );
};

export default Home;
