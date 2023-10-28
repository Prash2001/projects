import React, { useState } from 'react';
import img2 from '../img/img2.png';

function Front() {
  const [init, setInit] = useState({
    transform: '',
    transition: '',
  });

  function handleWheel(event) {
    event.preventDefault();
    setInit({
      transform: 'scale(5)',
      transition: 'transform 8s ease',
    });

    var ele = document.getElementById('id1');
    ele.style.transform = 'scale(1.15)';
    ele.style.transition = 'transform 4s ease';

    var ele2 = document.getElementById('layer5');
    setTimeout(function () {
      ele2.remove();
    }, 4000);
  }

  return (
    <div id='layer5' className="overlap-container">
      <div className="component component-2">
        <img
          className='img5'
          src={img2}
          alt="Component 2"
          onWheel={handleWheel}
          style={{ transform: `${init.transform}`, transition: `${init.transition}` }}
        />
      </div>
    </div>
  );
}

export default Front;
